package com.aristidevs.composetesting.components

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class ArisComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest() {
        composeTestRule.setContent {
            ArisComponent()
        }

        //FINDER
        composeTestRule.onNodeWithText("aris", ignoreCase = true)
        composeTestRule.onNodeWithTag("component1")
        composeTestRule.onNodeWithContentDescription("superImage")

        composeTestRule.onAllNodesWithText("a")
        composeTestRule.onAllNodesWithTag("component1")
        composeTestRule.onAllNodesWithContentDescription("visualIcon")

        //ACTIONS
        composeTestRule.onNodeWithText("aris", ignoreCase = true).performClick()
        composeTestRule.onAllNodesWithText("a").onFirst().performClick()
        composeTestRule.onNodeWithText("aris").performTouchInput {
            longClick()
            doubleClick()
            swipeDown()
            swipeUp()
            swipeLeft()
            swipeRight()
        }
        composeTestRule.onNodeWithText("aris").performScrollTo().performClick().performTextInput("")
        composeTestRule.onNodeWithText("aris").performImeAction()
        composeTestRule.onNodeWithText("aris").performTextClearance()
        composeTestRule.onNodeWithText("aris").performTextInput("adwdawdawdawd")
        composeTestRule.onNodeWithText("aris").performTextReplacement("dawdaw")

        //ASSERTIONS
        composeTestRule.onNodeWithText("aris").assertExists()
        composeTestRule.onNodeWithText("aris").assertDoesNotExist()
        composeTestRule.onNodeWithText("aris").assertContentDescriptionEquals("EADWAD")
        composeTestRule.onNodeWithText("aris").assertContentDescriptionContains("EADWAD")
        composeTestRule.onNodeWithText("aris").assertIsDisplayed()
        composeTestRule.onNodeWithText("aris").assertIsNotDisplayed()
        composeTestRule.onNodeWithText("aris").assertIsEnabled()
        composeTestRule.onNodeWithText("aris").assertIsNotEnabled()
        composeTestRule.onNodeWithText("aris").assertIsSelected()
        composeTestRule.onNodeWithText("aris").assertIsNotSelected()
        composeTestRule.onNodeWithText("aris").assertIsFocused()
        composeTestRule.onNodeWithText("aris").assertIsNotFocused()
        composeTestRule.onNodeWithText("aris").assertIsOn()
        composeTestRule.onNodeWithText("aris").assertIsOff()
        composeTestRule.onNodeWithText("aris").assertTextEquals("")
        composeTestRule.onNodeWithText("aris").assertTextContains("Aris")
    }

    @Test
    fun whenComponentStart_thenVerifyContentIsAris(){
        composeTestRule.setContent {
            ArisComponent()
        }

        composeTestRule.onNodeWithText("aris", ignoreCase = true).assertExists()
        composeTestRule.onNodeWithTag("textFieldName").assertTextContains("Aris")
    }

    @Test
    fun whenNameIsAdded_thenVerifyTextContainGreeting(){
        composeTestRule.setContent {
            ArisComponent()
        }

        composeTestRule.onNodeWithTag("textFieldName").performTextClearance()
        composeTestRule.onNodeWithTag("textFieldName").performTextInput("Pepe")
        composeTestRule.onNodeWithTag("textGreeting").assertTextEquals("Te llamas Pepe")
    }
}