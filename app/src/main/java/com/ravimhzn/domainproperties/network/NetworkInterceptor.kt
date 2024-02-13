package com.ravimhzn.domainproperties.network

import android.util.Log
import com.ravimhzn.domainproperties.util.LOG_INFO
import com.ravimhzn.domainproperties.util.NetworkUtil
import com.ravimhzn.domainproperties.util.Views
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import javax.inject.Inject

private const val NO_NETWORK_CONNECTION = 9999
private const val SYSTEM_ERROR = 9991

class NetworkInterceptor : Interceptor {

    lateinit var networkUtil: NetworkUtil

    override fun intercept(chain: Interceptor.Chain): Response {
        networkUtil = NetworkUtil(Views.context())
        //Todo check internet and handle error globally
        return try {
            val request = chain.request()
            Log.i(LOG_INFO, "###### ${request.url} ######")
            val response = chain.proceed(request)
            if(response.isSuccessful){
                Log.i(LOG_INFO, "###### ${response.networkResponse} ######")
            }

            response
        } catch (e: Exception) {
            handleError(chain, SYSTEM_ERROR, "Error :: $e")
        }
    }

    private fun handleError(chain: Interceptor.Chain, errorCode: Int, message: String) =
        Response.Builder()
            .code(errorCode)
            .protocol(Protocol.HTTP_2)
            .message(message)
            .request(chain.request())
            .build()
}