package com.ravimhzn.domainproperties.model

data class Advertiser(
    val id: Int,
    val images: Images,
    val name: String,
    val preferred_color_hex: String
)