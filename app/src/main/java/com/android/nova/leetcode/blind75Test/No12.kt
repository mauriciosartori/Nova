package com.android.nova.leetcode.blind75Test
/**
 *
 */
class No12 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = threeSum(intArrayOf(-1,0,1,2,-1,-4))
            println("Result ${result.joinToString(", ")}")
        }
        fun threeSum(nums: IntArray): List<List<Int>> {
            val numsSorted = nums.sortedArray()
            val result = ArrayList<List<Int>>()

            for (i in numsSorted.indices) {
                if (i > 0 && numsSorted[i] == numsSorted[i - 1]) {
                    continue
                }

                var start = i + 1
                var end = numsSorted.size - 1
                while (start < end) {
                    val currentSum = numsSorted[i] + numsSorted[start] + numsSorted[end]
                    when {
                        currentSum > 0 -> end--
                        currentSum < 0 -> start++
                        else -> {
                            result.add(arrayListOf(numsSorted[i], numsSorted[start], numsSorted[end]))
                            start++
                            while (start < end && numsSorted[start] == numsSorted[start - 1]) {
                                start++
                            }
                        }
                    }
                }
            }
            return result
        }
    }
}