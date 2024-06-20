package com.android.nova.inverviewcamp.recursionbacktracking.recursive
/**
 * (Level: Very Easy) Fibonacci Series - Find the Nth element of the Fibonacci series - 1,1,2,3,5,8,..
 * We use this problem to demonstrate Recursion and Memoization
 */
class Fibonacci {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val target = 21
            val mapMemoization = HashMap<Int, Int>()
            println("The element target to find is $target")
            findFibonacci(target, mapMemoization)
        }

        fun findFibonacci(fibNumber:Int, mapMemoization:HashMap<Int, Int>):Int {
            if (fibNumber == 1 || fibNumber == 2) {
                return 1
            }
            if (mapMemoization.containsKey(fibNumber)) {
                return mapMemoization.getOrDefault(fibNumber, 1)
            }
            val result = findFibonacci(fibNumber - 1, mapMemoization ) + findFibonacci(fibNumber - 2, mapMemoization )
            mapMemoization[fibNumber] = result
            print(" $result -")
            return result
        }
    }
}