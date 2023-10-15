package com.example.binary_converter.logic
import java.math.BigDecimal
import kotlin.math.floor
import kotlin.math.log10
class Converter {

    public fun toBinary(number: BigDecimal): String {
        if (number == 0 as BigDecimal) {
            return "0"
        } else if (number == 1 as BigDecimal) {
            return "1"
        } else if (number < 0 as BigDecimal) {
            throw IllegalArgumentException("Input must be a non-negative integer")
        }
        return convertToBinary(number)
    }

    private fun convertToBinary(number: BigDecimal): String {
        if (number == 0 as BigDecimal) {
            return ""
        }
        val quotient = number / 2 as BigDecimal
        val remainder = number % 2 as BigDecimal
        return convertToBinary(quotient) + remainder
    }
}
