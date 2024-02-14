package com.ravimhzn.domainproperties.model

import com.ravimhzn.domainproperties.BaseUnitTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class RentalPropertyResponseTest: BaseUnitTest() {

    private lateinit var rentalPropertyResponse: RentalPropertyResponse

    override fun setup() {
        super.setup()
        rentalPropertyResponse = RentalPropertyResponse()
    }

    @Test
    fun testEmptyList() {
        val filteredResult = rentalPropertyResponse.getFilteredSearchResult()
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
        rentalPropertyResponse = RentalPropertyResponse(searchResult)
        val filteredResponse = rentalPropertyResponse.getFilteredSearchResult()
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
        rentalPropertyResponse = RentalPropertyResponse(searchResult)
        val filteredResponse = rentalPropertyResponse.getFilteredSearchResult()
        assertNotEquals(searchResult.size, filteredResponse?.size)
        assertFalse(filteredResponse!!.containsAll(searchResult))
        assertEquals(filteredResponse.size, 1)
    }
}