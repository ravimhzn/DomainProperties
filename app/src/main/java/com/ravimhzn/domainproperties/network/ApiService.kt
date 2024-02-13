package com.ravimhzn.domainproperties.network

import com.ravimhzn.domainproperties.model.PropertyRequest
import com.ravimhzn.domainproperties.model.PropertyResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("v1/search")
    suspend fun getPropertyFromNetwork(
        @Body request: PropertyRequest
    ): Response<PropertyResponse>


}