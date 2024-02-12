package com.ravimhzn.domainproperties.model

data class SearchResult(
    val additional_features: List<String>,
    val address: String,
    val advertiser: Advertiser,
    val auction_date: String,
    val bathroom_count: Double,
    val bedroom_count: Double,
    val carspace_count: Int,
    val date_listed: String,
    val dwelling_type: String,
    val earliest_inspections: List<EarliestInspection>,
    val geo_location: GeoLocation,
    val has_video: Boolean,
    val headline: String,
    val homepass_enabled: Boolean,
    val id: Int,
    val land_area: String,
    val large_land: Boolean,
    val lifecycle_status: String,
    val listing_type: String,
    val media: List<Media>,
    val metadata: Metadata,
    val price: String,
    val project: Project,
    val promo_level: String,
    val topspot: Topspot
)