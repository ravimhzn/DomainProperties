package com.ravimhzn.domainproperties.model

import java.io.Serializable

data class BuyerPropertyResponse(
    val search_results: List<SearchResult>? = null,
) : Serializable {

    fun getFilteredSearchResult(): List<SearchResult>? {
        //Todo
        val filteredList =
            search_results?.filter {
                it.price == "Contact Agent" || it.price == "Auction" || it.price?.contains(
                    "$"
                ) == true
            }
        return search_results
    }
}
