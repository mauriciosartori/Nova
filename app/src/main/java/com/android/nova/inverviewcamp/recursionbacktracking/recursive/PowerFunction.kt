package com.android.nova.inverviewcamp.recursionbacktracking.recursive
/**
 * Power Function: Implement a function to calculate x^n.
 * Both x and n can be positive/negative and overflow doesn't happen.
 * Try doing it in O(log(n)) time.
 *
 */
class PowerFunction {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val x = -2
            val n = 3
            val result = 1
            val numberOfOperations = 1
            println("The value of x is $x and n is $n")
            val power = calculatePower(x, n, result, numberOfOperations)
            println("The authentic power is $power")
        }
        fun calculatePower(x: Int, n: Int, result: Int, nop: Int):Int {
            //println("Iteration number $nop")
            // Define base case
            if (n == 0) {
                return result
            }

            val power = calculatePower(x, n -1, result, nop + 1)
            return power * x
        }
    }
}