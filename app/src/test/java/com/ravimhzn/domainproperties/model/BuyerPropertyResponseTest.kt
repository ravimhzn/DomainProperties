package com.ravimhzn.domainproperties.model

import com.ravimhzn.domainproperties.ui.BaseUnitTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class BuyerPropertyResponseTest: BaseUnitTest() {

    private lateinit var response: BuyerPropertyResponse

    override fun setup() {
        super.setup()
        response = BuyerPropertyResponse()
    }

    @Test
    fun testEmptyList() {
        val filteredResult = response.getFilteredSearchResult()
        assertTrue(filteredResult.isNullOrEmpty())
    }

    @Test
    fun testAllPricesContactAgentOrAuction() {
        val advertiser = Advertiser(1, Images(""), "", "")
        val searchResult = arrayListOf<SearchResult>()
        searchResult.add(
            SearchResult(
                101, "", advertiser, 0.0, 0.0,
                0, "", "", true, listOf(), "Contact Agent"
            )
        )
        searchResult.add(
            SearchResult(
                101, "", advertiser, 0.0, 0.0,
                0, "", "", true, listOf(), "Auction"
            )
        )
        searchResult.add(
            SearchResult(
                101, "", advertiser, 0.0, 0.0,
                0, "", "", true, listOf(), "Auction"
            )
        )
        response = BuyerPropertyResponse(searchResult)
        val filteredResponse = response.getFilteredSearchResult()
        assertEquals(searchResult.size, filteredResponse?.size)
        assertTrue(filteredResponse!!.containsAll(searchResult))
    }

    @Test
    fun testMixedPricesWithDollarSigns() {
        val advertiser = Advertiser(1, Images(""), "", "")
        val searchResult = arrayListOf<SearchResult>()
        searchResult.add(
            SearchResult(
                101, "", advertiser, 0.0, 0.0,
                0, "", "", true, listOf(), "$100"
            )
        )
        searchResult.add(
            SearchResult(
                101, "", advertiser, 0.0, 0.0,
                0, "", "", true, listOf(), ""
            )
        )
        response = BuyerPropertyResponse(searchResult)
        val filteredResponse = response.getFilteredSearchResult()
        assertNotEquals(searchResult.size, filteredResponse?.size)
        assertFalse(filteredResponse!!.containsAll(searchResult))
        assertEquals(filteredResponse.size, 1)
    }
}