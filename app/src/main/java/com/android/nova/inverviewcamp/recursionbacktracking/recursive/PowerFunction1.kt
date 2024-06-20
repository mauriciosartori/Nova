package com.android.nova.inverviewcamp.recursionbacktracking.recursive

import kotlin.math.abs

/**
 * Power Function: Implement a function to calculate x^n.
 * Both x and n can be positive/negative and overflow doesn't happen.
 * Try doing it in O(log(n)) time.
 *
 */
class PowerFunction1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val x = 2
            val n = 3

            println("The value of x is $x and n is $n")
            val power = calculatePower(x, n)
            println("The authentic power is $power")
        }
        fun calculatePower(x: Int, n: Int, ):Float {
            if (x ==0 && n <= 0) {
                throw ArithmeticException("valio dick trayce")
            }
            val result = positivePower(abs(x), abs(n))
            if (n < 0) {
                return (1f / result)
            }
            if (x < 0 && n % 2 !=0) {
                return result * (-1f)
            }

            return result * 1f
        }

        fun positivePower(x: Int, n: Int):Int {
            if (x == 1) {
                return x
            }
            if (n ==0) {
                return 1
            }
            val halfPower = positivePower(x, n  / 2 )

            if (n % 2 == 0) {
                return halfPower * halfPower
            }
            return halfPower * halfPower * x

        }
    }
}