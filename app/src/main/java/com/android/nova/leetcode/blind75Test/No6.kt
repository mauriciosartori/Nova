package com.android.nova.leetcode.blind75Test
/**
 *
 */
class No6 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun maxProduct(nums: IntArray): Int {
            if (nums.isEmpty()) return 0

            var maxProduct = nums[0]
            var minProduct = nums[0]
            var result = nums[0]

            for (i in 1 until nums.size) {
                val current = nums[i]
                val tempMax = maxOf(current, maxProduct * current, minProduct * current)
                minProduct = minOf(current, maxProduct * current, minProduct * current)
                maxProduct = tempMax

                result = maxOf(result, maxProduct)
            }

            return result
        }
    }
}