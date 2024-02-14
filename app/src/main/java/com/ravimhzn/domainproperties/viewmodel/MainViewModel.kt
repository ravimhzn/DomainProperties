package com.ravimhzn.domainproperties.viewmodel

import androidx.lifecycle.viewModelScope
import com.ravimhzn.domainproperties.framework.BaseViewModel
import com.ravimhzn.domainproperties.model.BuyerPropertyResponse
import com.ravimhzn.domainproperties.model.RentalPropertyResponse
import com.ravimhzn.domainproperties.repository.DomainPropertyDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.Serializable
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val propertyDataSource: DomainPropertyDataSource
) : BaseViewModel() {

    private val _rentalPropertyResponse = MutableStateFlow(RentalPropertyResponse())
    val rentalPropertyResponse: StateFlow<RentalPropertyResponse> = _rentalPropertyResponse

    private val _buyerPropertyResponse = MutableStateFlow(BuyerPropertyResponse())
    val buyerPropertyResponse: StateFlow<BuyerPropertyResponse> = _buyerPropertyResponse

    init {
        getRentalProperty()
        getBuyerProperty()
    }

    private fun getRentalProperty() {
        viewModelScope.launch {
            enqueue(propertyDataSource.getRentalProperty())
        }
    }

    private fun getBuyerProperty() {
        viewModelScope.launch {
            enqueue(propertyDataSource.getBuyerProperty())
        }
    }

    override fun onData(data: Serializable) {
        super.onData(data)
        when (data) {
            is RentalPropertyResponse -> {
                _rentalPropertyResponse.value = data
            }

            is BuyerPropertyResponse -> {
                _buyerPropertyResponse.value = data
            }
        }

    }
}
