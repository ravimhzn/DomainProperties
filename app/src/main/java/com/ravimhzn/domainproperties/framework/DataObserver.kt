package com.ravimhzn.domainproperties.framework

import java.io.Serializable

/**
 * Todo
 * Demonstration interface where we could use State to observe data in Fragment/ Activity more effectively isolating the UT.
 */
interface DataObserver {

    suspend fun registerObservers(viewModel: BaseViewModel) {
        viewModel.uiState.collect {
            when (it) {
                is State.Loaded -> {
                    onData(it.data)
                }

                is State.Error -> {
                    hideLoading()
                    onError(it.error)
                }

                is State.Loading -> {
                    showLoading()
                }

                else -> {
                    // do nothing
                }
            }
        }
    }

    fun onData(data: Serializable) {
        hideLoading()
    }

    fun showLoading() {
       //Todo handle loading for Activity/ fragments
    }


    fun hideLoading() {
        //Todo handle loading for Activity/ fragments
    }

    fun onError(error: NetworkError) {
        //Todo handle Error for Activity/ fragments
    }
}