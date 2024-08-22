package com.android.nova.leetcode.blind75Test.arrays
/**
 *
 */
class No4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
            productExceptSelf(intArrayOf(1,2,3,4))
        }

        fun productExceptSelf(nums: IntArray): IntArray {
            var leftProductArray = IntArray(nums.size)
            var leftProduct = 1
            var rightProductArray = IntArray(nums.size)
            var rightProduct = 1
            var result = IntArray(nums.size)
            for (i in nums.indices) {
                leftProductArray[i] = leftProduct
                leftProduct = leftProduct * nums[i]
            }
            for (i in nums.size - 1 downTo 0) {
                rightProductArray[i] = rightProduct
                rightProduct = rightProduct * nums[i]
            }
            for (i in nums.indices) {
                result[i] = rightProductArray[i] * leftProductArray[i]
            }

            println(leftProductArray.contentToString())
            println(rightProductArray.contentToString())
            println(result.contentToString())

            return result
        }
    }
}