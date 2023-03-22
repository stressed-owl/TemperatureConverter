package com.nikolay.temperatureconverter

import kotlin.math.round

internal fun fahrenheitToCelsius(
    fahrenheit: Double,
    isRound: Boolean,
): String {
    var conversion = (fahrenheit - 32) * 5 / 9
    if (isRound) { conversion = round(conversion) }
    return "%.1f".format(conversion)
}
