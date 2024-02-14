package com.ravimhzn.domainproperties.ui.views

import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.ravimhzn.domainproperties.BaseUnitTest
import com.ravimhzn.domainproperties.util.StringUtils
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AppToolbarTest : BaseUnitTest() {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testInitialStateAndTitle() {
        val testTitle = "Test Title"
        composeTestRule.setContent {
            MyComposeToolbar(appTitle = testTitle)
        }
        composeTestRule.onNodeWithText(testTitle).assertExists()
    }

    @Test
    fun testMenuVisibilityAndBuyAction() {
        var buyClicked = false
        val buyListener: () -> Unit = {
            buyClicked = true
        }
        composeTestRule.setContent {
            MyComposeToolbar(displayMenu = true, onMenuBuyListener = buyListener)
        }
        composeTestRule.onNodeWithContentDescription(StringUtils.contentDescMenu).performClick()
        assertTrue(composeTestRule.onNodeWithText(StringUtils.menuBuy).isDisplayed())

        composeTestRule.onNodeWithText(StringUtils.menuBuy).performClick()
        assertTrue(buyClicked)
        assertFalse(composeTestRule.onNodeWithText(StringUtils.menuBuy).isDisplayed())
    }

    @Test
    fun testMenuDismiss() {
        composeTestRule.setContent {
            MyComposeToolbar(displayMenu = true)
        }
        composeTestRule.onNodeWithContentDescription(StringUtils.contentDescMenu).performClick()
        assertTrue(composeTestRule.onNodeWithText(StringUtils.menuBuy).isDisplayed())

        composeTestRule.onNodeWithText(StringUtils.menuBuy).performClick()
        assertFalse(composeTestRule.onNodeWithText(StringUtils.menuBuy).isDisplayed())
    }
}