package com.ravimhzn.domainproperties.repository

import com.ravimhzn.domainproperties.model.BuyerPropertyResponse
import com.ravimhzn.domainproperties.model.PropertyRequest
import com.ravimhzn.domainproperties.model.RentalPropertyResponse
import com.ravimhzn.domainproperties.navigation.Screen
import com.ravimhzn.domainproperties.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class DomainPropertyRepository @Inject constructor(private val apiService: ApiService) :
    DomainPropertyDataSource {
    val list = arrayListOf<String>()

    init {
        list.add("Apartment/ Unit/ Flat")
    }

    override suspend fun getProperty(request: PropertyRequest) =
        apiService.getPropertyFromNetwork(request)

    override suspend fun getRentalProperty(): Response<RentalPropertyResponse> {
        return apiService.getRentalPropertyApi(list, Screen.RENT.route)
    }

    override suspend fun getBuyerProperty(): Response<BuyerPropertyResponse> {
        return apiService.getBuyerPropertyApi(list, Screen.BUY.route)
    }
}