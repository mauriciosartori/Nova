package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No10 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }

        fun getMaximumEatenDishCount(N: Int, D: Array<Int>, K: Int): Int {
            if (N == 1 && D.size == 1) {
                return 1
            }
            val previousDishes = HashMap<Int, Int>()
            val dishBar = D
            var dishCounter = 0

            for (i in 0 until N) {
                val currentDish = dishBar[i]
                if (!previousDishes.contains(currentDish) || (dishCounter - previousDishes.getOrDefault(currentDish, 0)) > K ) {
                    previousDishes[currentDish] = dishCounter
                    dishCounter++
                }
            }
            return dishCounter
        }
    }
}