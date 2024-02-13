package com.ravimhzn.domainproperties.model

import java.io.Serializable

data class PropertyResponse(
    val search_results: List<SearchResult>,
) : Serializable {

    fun getFilteredSearchResult(): List<SearchResult> {
        val filteredList =
            search_results.filter { it.price == "Contact Agent" || it.price == "Auction" || it.price?.contains("$") == true }
        println("###### debug --> Filtered Search Results :: ${filteredList.size}")
        for (list in filteredList) {
            println("###### debug --> $list")
        }
        return filteredList
    }
}
