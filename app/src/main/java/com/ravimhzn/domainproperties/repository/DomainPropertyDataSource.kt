package com.ravimhzn.domainproperties.repository

import com.ravimhzn.domainproperties.model.PropertyRequest
import com.ravimhzn.domainproperties.model.PropertyResponse
import retrofit2.Response

interface DomainPropertyDataSource {

    suspend fun getProperty(request: PropertyRequest): Response<PropertyResponse>
}