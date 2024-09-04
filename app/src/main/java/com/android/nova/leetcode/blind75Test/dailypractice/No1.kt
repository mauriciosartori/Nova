package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //val nums = intArrayOf(3,2,3)
            val nums = intArrayOf(3,2,4)
            val target = 6
            val result = twoSum(nums, target)
            println("The result for No1 is ${result.contentToString()}")
        }
        fun twoSum(nums: IntArray, target: Int): IntArray {
            var leftIndex = 0
            var rightIndex = 1
            var sum = nums[0]

            while (rightIndex < nums.size && leftIndex < nums.size) {
                if (sum < target) {
                    if (rightIndex < nums.size) {
                        sum = sum + nums[rightIndex]
                        rightIndex++
                    }
                } else if (sum > target) {
                    if (leftIndex < nums.size) {
                        sum = sum - nums[leftIndex]
                        leftIndex++
                    }
                } else {
                    return intArrayOf(leftIndex, rightIndex)
                }
            }
            return intArrayOf(leftIndex, rightIndex)
        }
    }
}