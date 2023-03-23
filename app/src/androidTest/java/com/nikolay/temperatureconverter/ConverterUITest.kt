package com.nikolay.temperatureconverter

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.nikolay.temperatureconverter.ui.theme.TemperatureConverterTheme
import org.junit.Rule
import org.junit.Test

class ConverterUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun convert_40_to_fahrenheit_temp() {
        composeTestRule.setContent {
            TemperatureConverterTheme {
                ConverterUI()
            }
        }

        val celsius = 40
        val expectedTemperature = 104.0
        composeTestRule.onNodeWithText("From C to F").performTextInput("$celsius")
        composeTestRule.onNodeWithText("$celsius℃ = $expectedTemperature℉").assertExists(
            "No node was found with this text"
        )
    }

    @Test
    fun convert_10000_to_fahrenheit_temp() {
        composeTestRule.setContent {
            TemperatureConverterTheme {
                ConverterUI()
            }
        }

        val celsius = 10_000
        val expectedTemperature = 18032.0
        composeTestRule.onNodeWithText("From C to F").performTextInput("$celsius")
        composeTestRule.onNodeWithText("$celsius℃ = $expectedTemperature℉").assertExists(
            "No node was found with this text"
        )
    }

    @Test
    fun convert_400_fahrenheit_to_celsius_temp() {
        composeTestRule.setContent {
            TemperatureConverterTheme {
                ConverterUI()
            }
        }

        val fahrenheit = 400
        val expectedTemperature = 204.4
        composeTestRule.onNodeWithText("From F to C").performTextInput("$fahrenheit")
        composeTestRule.onNodeWithText("$fahrenheit℉ = $expectedTemperature℃").assertExists(
            "No node was found with this text"
        )
    }

    @Test
    fun convert_5523432_fahrenheit_to_celsius_temp() {
        composeTestRule.setContent {
            TemperatureConverterTheme {
                ConverterUI()
            }
        }

        val fahrenheit = 5_523_432
        val expectedTemperature = 3_068_555.6
        composeTestRule.onNodeWithText("From F to C").performTextInput("$fahrenheit")
        composeTestRule.onNodeWithText("$fahrenheit℉ = $expectedTemperature℃").assertExists(
            "No node was found with this text"
        )
    }
}