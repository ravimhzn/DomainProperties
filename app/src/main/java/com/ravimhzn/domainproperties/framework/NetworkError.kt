package com.ravimhzn.domainproperties.framework

import java.io.Serializable

//Dummy Error class
data class NetworkError(
    var statusCode: String?,
    var statusMessage: String?
) : Serializable