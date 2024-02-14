package com.ravimhzn.domainproperties.ui.views

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.ravimhzn.domainproperties.BaseUnitTest
import com.ravimhzn.domainproperties.model.Advertiser
import com.ravimhzn.domainproperties.model.Images
import com.ravimhzn.domainproperties.model.RentalPropertyResponse
import com.ravimhzn.domainproperties.model.SearchResult
import com.ravimhzn.domainproperties.util.StringUtils
import com.ravimhzn.domainproperties.viewmodel.MainViewModel
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.Flow
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DomainRentPropertiesTest : BaseUnitTest() {

    @get:Rule
    val composeTestRule = createComposeRule()

    lateinit var mockedMainViewModel: MainViewModel

    override fun setup() {
        super.setup()
        mockedMainViewModel = MainViewModel(mockk())
    }

    @Test
    fun testInitialRender_EmptyData() {
        val advertiser = Advertiser(1, Images(""), "", "")
        val searchResult = arrayListOf<SearchResult>()
        searchResult.add(
            SearchResult(
                101, "", advertiser, 0.0, 0.0,
                0, "", "", true, listOf(), ""
            )
        )
        mockedMainViewModel.onData(RentalPropertyResponse(searchResult))

        composeTestRule.setContent {
            DomainRentPropertiesView(mockk(), mockedMainViewModel)
        }
        composeTestRule.onNodeWithText(StringUtils.appTitleRent).assertExists()
    }


}