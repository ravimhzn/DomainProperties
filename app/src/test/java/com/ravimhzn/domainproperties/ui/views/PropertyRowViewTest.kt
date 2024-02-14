package com.ravimhzn.domainproperties.ui.views

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.ravimhzn.domainproperties.model.Advertiser
import com.ravimhzn.domainproperties.model.Images
import com.ravimhzn.domainproperties.model.Media
import com.ravimhzn.domainproperties.model.SearchResult
import com.ravimhzn.domainproperties.util.StringUtils
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PropertyRowViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testInitialStateAndDataBinding() {
        val advertiser = Advertiser(1, Images(""), "", "")
        val mediaList = arrayListOf<Media>()
        mediaList.add(Media("https://www.google.com", "", ""))
        val searchResult = SearchResult(
            101, "123 Sydney Street", advertiser, 2.0, 3.0,
            1, "[\"Apartment / Unit / Flat\"]", "", true, mediaList, "$1,000.00"
        )
        composeTestRule.setContent {
            PropertyRowView(searchResult)
        }
        composeTestRule.onNodeWithText("$1,000.00").assertExists()
        composeTestRule.onNodeWithText("2.0 bath, 3.0 bed, 1 car").assertExists()
        composeTestRule.onNodeWithText("123 Sydney Street").assertExists()
        composeTestRule.onNode(hasContentDescription(StringUtils.propertyImageContentDesc))
        composeTestRule.onNode(hasContentDescription(StringUtils.propertyImageContentDesc))
    }
}