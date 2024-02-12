package com.ravimhzn.domainproperties.repository

import com.ravimhzn.domainproperties.model.PropertyRequest
import com.ravimhzn.domainproperties.network.ApiService
import javax.inject.Inject

class DomainPropertyRepository @Inject constructor(private val apiService: ApiService) :
    DomainPropertyDataSource {
    override suspend fun getProperty(request: PropertyRequest) =
        apiService.getPropertyFromNetwork(request)
}