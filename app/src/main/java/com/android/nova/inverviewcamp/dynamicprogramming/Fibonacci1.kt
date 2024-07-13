package com.android.nova.inverviewcamp.dynamicprogramming
/**
 *
 */
class Fibonacci1 {
    companion object {

        var iterations = 0

        @JvmStatic
        fun main(args: Array<String>) {
            println("Fibonacci series using dynamic programming")
            displayFibonacci()
        }

        fun displayFibonacci() {
            val result = fibo(7)
            println("The result of this is $result")
        }

        fun fibo(currentNumber: Int): Int{
            // Defining base cases
            if (currentNumber == 0) {
                return 1
            }
            if (currentNumber == 1) {
                return 1
            }

            return fibo(currentNumber - 1 ) + fibo(currentNumber - 2)
        }

    }
}