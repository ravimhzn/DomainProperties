package com.ravimhzn.domainproperties.repository

import com.ravimhzn.domainproperties.model.PropertyRequest
import com.ravimhzn.domainproperties.model.PropertyResponse
import com.ravimhzn.domainproperties.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class DomainPropertyRepository @Inject constructor(private val apiService: ApiService) :
    DomainPropertyDataSource {
    override suspend fun getProperty(request: PropertyRequest) =
        apiService.getPropertyFromNetwork(request)

    override suspend fun getPropertyViaQuery(
        dwelling: List<String>,
        searchType: String
    ): Response<PropertyResponse> {
        return apiService.getPropertyFromNetworkViaQuery(dwelling, searchType)
    }
}