package com.ravimhzn.domainproperties.model

import java.io.Serializable

data class SearchResult(
    val id: Int,
    val address: String?,
    val advertiser: Advertiser?,
    val bathroom_count: Double?,
    val bedroom_count: Double?,
    val carspace_count: Int?,
    val dwelling_type: String,
    val headline: String,
    val homepass_enabled: Boolean,
    val media: List<Media>,
    val price: String? = ""
): Serializable