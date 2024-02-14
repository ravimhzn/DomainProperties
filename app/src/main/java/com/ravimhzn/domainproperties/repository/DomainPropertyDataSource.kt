package com.ravimhzn.domainproperties.repository

import com.ravimhzn.domainproperties.model.BuyerPropertyResponse
import com.ravimhzn.domainproperties.model.PropertyRequest
import com.ravimhzn.domainproperties.model.RentalPropertyResponse
import com.ravimhzn.domainproperties.navigation.Screen
import retrofit2.Response

interface DomainPropertyDataSource {

    suspend fun getProperty(request: PropertyRequest): Response<RentalPropertyResponse>

    suspend fun getRentalProperty(): Response<RentalPropertyResponse>

    suspend fun getBuyerProperty(): Response<BuyerPropertyResponse>

}