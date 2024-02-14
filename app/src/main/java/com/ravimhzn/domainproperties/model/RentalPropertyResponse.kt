package com.ravimhzn.domainproperties.model

import android.util.Log
import com.ravimhzn.domainproperties.util.LOG_INFO
import java.io.Serializable

data class RentalPropertyResponse(
    val search_results: List<SearchResult>? = null,
) : Serializable {

    fun getFilteredSearchResult(): List<SearchResult>? {
        val filteredList =
            search_results?.filter { it.price == "Contact Agent" || it.price == "Auction" || it.price?.contains("$") == true }
        Log.i(LOG_INFO, "Rental Filtered Search Results :: ${filteredList?.size}")
        return filteredList
    }
}
