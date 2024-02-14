package com.ravimhzn.domainproperties.viewmodel

import com.ravimhzn.domainproperties.model.Advertiser
import com.ravimhzn.domainproperties.model.BuyerPropertyResponse
import com.ravimhzn.domainproperties.model.Images
import com.ravimhzn.domainproperties.model.RentalPropertyResponse
import com.ravimhzn.domainproperties.model.SearchResult
import com.ravimhzn.domainproperties.repository.DomainPropertyDataSource
import com.ravimhzn.domainproperties.ui.BaseViewModelTest
import io.mockk.mockk
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest : BaseViewModelTest() {

    lateinit var viewModel: MainViewModel

    @Test
    fun testOnDataRentalProperty() = runBlocking {
        val propertyDataSource = mockk<DomainPropertyDataSource>()
        viewModel = MainViewModel(propertyDataSource)
        viewModel.onData(RentalPropertyResponse())
        assertNull(viewModel.rentalPropertyResponse.value.search_results)

        val advertiser = Advertiser(1, Images(""), "", "")
        val searchResult = arrayListOf<SearchResult>()
        searchResult.add(
            SearchResult(
                101, "", advertiser, 0.0, 0.0,
                0, "", "", true, listOf(), ""
            )
        )
        viewModel.onData(RentalPropertyResponse(searchResult))
        assertTrue(viewModel.rentalPropertyResponse.value.search_results?.size == 1)
    }

    @Test
    fun testOnDataBuyerProperty() = runBlocking {
        val propertyDataSource = mockk<DomainPropertyDataSource>()
        viewModel = MainViewModel(propertyDataSource)
        viewModel.onData(BuyerPropertyResponse())
        assertNull(viewModel.buyerPropertyResponse.value.search_results)

        val advertiser = Advertiser(1, Images(""), "", "")
        val searchResult = arrayListOf<SearchResult>()
        searchResult.add(
            SearchResult(
                101, "", advertiser, 0.0, 0.0,
                0, "", "", true, listOf(), ""
            )
        )
        viewModel.onData(BuyerPropertyResponse(searchResult))
        assertTrue(viewModel.buyerPropertyResponse.value.search_results?.size == 1)
    }
}