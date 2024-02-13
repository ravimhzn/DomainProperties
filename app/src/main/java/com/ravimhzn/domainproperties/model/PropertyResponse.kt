package com.ravimhzn.domainproperties.model

import java.io.Serializable

data class PropertyResponse(
    val allows_immediate_property_alert: Boolean,
    val new_results: Any,
    val results_returned: Int,
    val results_total: Int,
    val school_metadata: Any,
    val search_insights: SearchInsights,
    val search_results: List<SearchResult>,
    val tracking: Tracking,
    val tracking_metadata: TrackingMetadata
) : Serializable
