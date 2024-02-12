package com.ravimhzn.domainproperties.viewmodel

import androidx.lifecycle.viewModelScope
import com.ravimhzn.domainproperties.framework.BaseViewModel
import com.ravimhzn.domainproperties.model.PropertyRequest
import com.ravimhzn.domainproperties.repository.DomainPropertyDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.Serializable
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val propertyDataSource: DomainPropertyDataSource
) : BaseViewModel() {

    fun getPropertyResponse() {
        viewModelScope.launch {
            val list = arrayListOf<String>()
            list.add("Apartment/ Unit/ Flat")
            enqueue(propertyDataSource.getProperty(PropertyRequest(list, "rent")))
        }
    }

    override fun onData(data: Serializable) {
        super.onData(data)
        println("debug --> OnData:: $data")
    }
}
