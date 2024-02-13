package com.ravimhzn.domainproperties.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ravimhzn.domainproperties.framework.BaseViewModel
import com.ravimhzn.domainproperties.model.PropertyResponse
import com.ravimhzn.domainproperties.navigation.Screen
import com.ravimhzn.domainproperties.repository.DomainPropertyDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val propertyDataSource: DomainPropertyDataSource
) : BaseViewModel() {

    init {
        getPropertyResponse(Screen.RENT)
    }

    private fun getPropertyResponse(screen: Screen) {
        viewModelScope.launch {
            val list = arrayListOf<String>()
            list.add("Apartment/ Unit/ Flat")
            enqueue(propertyDataSource.getPropertyViaQuery(list, screen.route.lowercase()))
        }
    }
}
