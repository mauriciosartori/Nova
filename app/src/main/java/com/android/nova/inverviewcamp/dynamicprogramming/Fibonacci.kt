package com.android.nova.inverviewcamp.dynamicprogramming
/**
 *
 */
class Fibonacci {
    companion object {

        var iterations = 0
        @JvmStatic
        fun main(args: Array<String>) {
            println("Fibonacci series using dynamic programming")
            displayFibonacci()
        }

        fun displayFibonacci() {
            val target = 9
            val iterationsMap: MutableMap<Int, Int> = HashMap()
            val result = fibonacci(target, iterationsMap)
            println("The result of the fibonacci of $target is $result")
            println("And the number of iterations is $iterations")
        }

        fun fibonacci(target: Int, iterationsMap: MutableMap<Int, Int>): Int {
            iterations++
            if (target == 1) {
                return 1
            }
            if (target == 2) {
                return 1
            }
            if (iterationsMap.containsKey(target)) {
                println("Entro!")
                return iterationsMap.getOrDefault(target,0)
            }
            val result = fibonacci( target - 1, iterationsMap) + fibonacci( target - 2, iterationsMap)
            iterationsMap[target] = result
            return result
        }
    }
}