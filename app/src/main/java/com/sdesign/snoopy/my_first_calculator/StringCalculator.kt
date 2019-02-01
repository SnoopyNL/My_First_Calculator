package com.sdesign.snoopy.my_first_calculator

class StringCalculator {
    fun calculate (calculationList: List<String>): Float {
        var currentOp = ""
        var currentNumber = 0.00

        calculationList.forEach { token ->

            when {
                token.equals("+")
                        || token.equals("-")
                        || token.equals("x")
                        || token.equals("/") -> currentOp = token

                currentOp.equals("-") -> currentNumber -= token.toFloat()
                currentOp.equals("/") -> currentNumber /= token.toFloat()
                currentOp.equals("x") -> currentNumber *= token.toFloat()

                else -> currentNumber += token.toFloat()
            }
        }

        return currentNumber.toFloat()

    }
}