package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No9 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        // Write any import statements here

        fun getMaximumEatenDishCount(N: Int, D: Array<Int>, K: Int): Int {

            if (N == 1 && D.size == 1) {
                return 1
            }
            val previousDishes = HashSet<Int>()
            val dishBar = D
            var lastIndex = 0
            var dishCounter = 0

            for (i in 0 until N) {
                val currentDish = dishBar[i]
                if (i < K) {
                    previousDishes.add(currentDish)
                    dishCounter++
                    continue
                }
                if (!previousDishes.contains(currentDish)) {
                    previousDishes.remove(dishBar[lastIndex])
                    lastIndex++
                    previousDishes.add(currentDish)
                    dishCounter++
                }
            }
            return dishCounter
        }
    }
}