package com.ravimhzn.domainproperties.framework

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.ravimhzn.domainproperties.util.Callable
import com.ravimhzn.domainproperties.util.LOG_ERROR
import com.ravimhzn.domainproperties.util.NetworkUtil
import com.ravimhzn.domainproperties.util.UNKNOWN_ERROR
import com.ravimhzn.domainproperties.util.UNKNOWN_ERROR_CODE
import com.ravimhzn.domainproperties.util.errorMessage
import com.ravimhzn.domainproperties.util.getErrorBody
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.Serializable
import javax.inject.Inject

class BaseViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var networkUtil: NetworkUtil

    private val _uiState = MutableStateFlow<State>(State.Empty)
    val uiState: StateFlow<State> = _uiState

    protected lateinit var scope: CoroutineScope

    init {
        setScope()
    }

    private fun setScope() {
        val handler = CoroutineExceptionHandler { _, throwable ->
            Log.e(LOG_ERROR, "Coroutine Exception :: ${throwable.localizedMessage}")
            _uiState.value = State.Error(getDefaultError())
        }
        scope = CoroutineScope(Dispatchers.IO + handler)
    }

    protected fun <T> enqueue(response: Response<T>) {
        scope.launch {
            handleEnqueue(response)
        }
    }

    private fun <T> handleEnqueue(response: Response<T>) {
        if (response.isSuccessful) {
            response.body()?.let {
                try {
                    onData(response.body() as Serializable)

                } catch (e: Exception) {
                    Log.e(LOG_ERROR,"${response.errorMessage()} :: $e")
                    onError(getDefaultError())
                }
            } ?: run {
                Log.e(LOG_ERROR, response.errorMessage())
                onError(getDefaultError())
            }

        } else {
            handleError(response)
        }
    }
    /**
     * Parse the error from Network API.
     * Since we don't know the proper error format coming from network,
     * this is just a dummy method on how we can handle error assuming "NetworkError" as a format.
     */
    private fun <T> handleError(response: Response<T>) {
        var statusCode = ""
        var statusMessage = ""
        try {
            val errorMessage = Gson().fromJson(
                response.getErrorBody()?.charStream(),
                NetworkError::class.java
            )
            statusCode = errorMessage?.statusCode ?: ""
            statusMessage = errorMessage?.statusMessage ?: ""
        } catch (e: Exception) {
            Log.e(LOG_ERROR,"${response.errorMessage()}\t$e")
        }

        val error = NetworkError(
            statusCode,
            statusMessage
        )
        onError(error)
    }

    fun checkInternetConnection(): Boolean {
        val connected = isInternetConnected()
        //Todo use state
        return connected
    }

    private fun isInternetConnected(): Boolean {
        return networkUtil.isInternetAvailable()
    }

    /**
     * Below function is required to make sure loading is called before enqueue
     * If there is custom loading screen, then avoid calling this function and instead just use enqueue
     */
    protected fun start(callable: Callable<Boolean>) {
        loading()
        callable.call(true)
    }

    protected fun loading() {
        _uiState.value = State.Loading
    }

    fun onData(data: Serializable) {
        _uiState.value = State.Loaded(data)
    }

    fun onError(error: NetworkError) {
        try {
            _uiState.value = State.Error(error)
            error.statusMessage?.let {
                Log.e(LOG_ERROR,"Exception :: $it")
            }
            Log.e(LOG_ERROR,"BaseViewModel :: onError called")
        } catch (e: Exception) {
            Log.e(LOG_ERROR,"Exception :: $e")
        }
    }

    private fun emptyState() {
        _uiState.value = State.Empty
    }


    private fun getDefaultError() = NetworkError(
        UNKNOWN_ERROR_CODE,
        UNKNOWN_ERROR
    )

    override fun onCleared() {
        emptyState()
        scope.cancel()
        super.onCleared()
    }
}