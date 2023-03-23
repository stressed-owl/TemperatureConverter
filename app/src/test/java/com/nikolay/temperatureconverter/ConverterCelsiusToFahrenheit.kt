package com.nikolay.temperatureconverter

import junit.framework.TestCase.assertEquals
import org.junit.Test

class ConverterCelsiusToFahrenheit {

    @Test
    fun convert_50_celsius_to_fahrenheit() {
        val celsius = 50.0
        val expectedTemperature = 122.0.toString()
        val actualTemperature = celsiusToFahrenheit(celsius, false)
        assertEquals(expectedTemperature, actualTemperature)
    }

    @Test
    fun convert_120_31_celsius_to_fahrenheit() {
        val celsius = 120.31
        val expectedTemperature = 248.6.toString()
        val actualTemperature = celsiusToFahrenheit(celsius, false)
        assertEquals(expectedTemperature, actualTemperature)
    }
}