package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No49 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(1, 0, 1, 1, 1)
            val target = 0
            println(search(nums, target))
        }
        fun search(nums: IntArray, target: Int): Boolean {
            var left = 0
            var right = nums.size - 1

            while (left <= right) {
                val middle = (left + right) / 2

                if (target > nums[middle]) {
                    if (nums[right] < target) {
                        // Go to left
                        right = middle - 1
                    } else {
                        // Go to right
                        left = middle + 1
                    }
                } else if (target < nums[middle]) {
                    if (nums[left] > target) {
                        // Go to right
                        left = middle + 1
                    } else {
                        // Go to left
                        right = middle - 1
                    }
                } else {
                    return true
                }
            }
            return false
        }
    }
}