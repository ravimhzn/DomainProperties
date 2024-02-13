package com.ravimhzn.domainproperties.network

import com.ravimhzn.domainproperties.model.PropertyRequest
import com.ravimhzn.domainproperties.model.PropertyResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("v1/search")
    suspend fun getPropertyFromNetwork(
        @Body request: PropertyRequest
    ): Response<PropertyResponse>

    @POST("v1/search")
    suspend fun getPropertyFromNetworkViaQuery(
        @Query("dwelling_types") tier: List<String>,
        @Query("search_mode") language: String
    ): Response<PropertyResponse>
}