package com.nikolay.temperatureconverter

import junit.framework.TestCase.assertEquals
import org.junit.Test

class ConverterFahrenheitToCelsius {

    @Test
    fun convert_20_fahrenheit_to_celsius() {
        val fahrenheit = 20.0
        val expectedTemperature = -6.7
        val actualTemperature = fahrenheitToCelsius(fahrenheit, false)
        assertEquals(expectedTemperature.toString(), actualTemperature)
    }

    @Test
    fun convert_80_2_fahrenheit_to_celsius() {
        val fahrenheit = 80.2
        val expectedTemperature = 26.8
        val actualTemperature = fahrenheitToCelsius(fahrenheit, false)
        assertEquals(expectedTemperature.toString(), actualTemperature)
    }
}