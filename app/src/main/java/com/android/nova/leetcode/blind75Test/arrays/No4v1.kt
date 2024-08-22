package com.android.nova.leetcode.blind75Test.arrays
/**
 *
 */
class No4v1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
            productExceptSelf(intArrayOf(1,2,3,4))
        }

        fun productExceptSelf(nums: IntArray): IntArray {

            var leftProduct = 1
            var rightProduct = 1
            var result = IntArray(nums.size)
            for (i in nums.indices) {
                result[i] = leftProduct
                leftProduct = leftProduct * nums[i]
            }
            for (i in nums.size - 1 downTo 0) {
                result[i] = result[i] * rightProduct
                rightProduct = rightProduct * nums[i]
            }

            println(result.contentToString())

            return result
        }
    }
}