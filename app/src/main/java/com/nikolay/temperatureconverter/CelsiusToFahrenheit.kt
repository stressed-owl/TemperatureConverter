package com.nikolay.temperatureconverter

import kotlin.math.round

internal fun celsiusToFahrenheit(
    celsius: Double,
    isRound: Boolean,
): String {
    var conversion = (celsius * 9 / 5) + 32
    if (isRound) { conversion = round(conversion) }
    return "%.1f".format(conversion)
}
