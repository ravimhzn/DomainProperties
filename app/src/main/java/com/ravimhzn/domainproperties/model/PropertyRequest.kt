package com.ravimhzn.domainproperties.model

import java.io.Serializable

data class PropertyRequest(
    val dwelling_types: List<String>,
    val search_mode: String
): Serializable