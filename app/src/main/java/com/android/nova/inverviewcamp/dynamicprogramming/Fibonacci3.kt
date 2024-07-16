package com.android.nova.inverviewcamp.dynamicprogramming
/**
 *
 */
class Fibonacci3 {
    companion object {

        var iterations = 0

        @JvmStatic
        fun main(args: Array<String>) {
            println("Fibonacci series using dynamic programming")
            displayFibonacci()
        }

        fun displayFibonacci() {
            val result = fibo(8)
            println("The result of this pex is $result")
        }

        fun fibo(number:Int):Int {
            // Base cases
            if (number == 1) {
                return 1
            }
            if (number == 0) {
                return 0
            }

            return (fibo(number - 1) + fibo(number - 2))
        }
    }

}