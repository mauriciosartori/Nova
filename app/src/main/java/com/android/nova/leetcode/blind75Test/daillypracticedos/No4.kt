package com.android.nova.leetcode.blind75Test.daillypracticedos
/**
 *
 */
class No4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val grantsArray = doubleArrayOf(2.0, 100.0, 50.0, 120.0, 1000.0)
            val newBudget = 190.0

            val cap = findGrantsCap(grantsArray, newBudget)
            println("Output: $cap")
        }

        fun findGrantsCap(grantsArray: DoubleArray, newBudget: Double): Double {
            var maxAmount = newBudget / grantsArray.size
            grantsArray.sort()

            var totalUsed = 0.0
            var startIndex = 0
            var result = DoubleArray(grantsArray.size)
            for ((index, value) in grantsArray.withIndex()){
                if (value < maxAmount) {
                    totalUsed += value
                    result[index] = value
                } else {
                    startIndex = index
                    break
                }
            }

            maxAmount = (newBudget - totalUsed) / (grantsArray.size - startIndex )
            for (i in startIndex until grantsArray.size) {
                result[i] = maxAmount
            }

            println(result.joinToString())
            return 0.0
        }
    }
}