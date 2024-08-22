package com.android.nova.leetcode.blind75Test.arrays
/**
 *
 */
class No8 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = search(intArrayOf(4,5,6,7,0,1,2), 0)
            println("Result $result")


        }

        fun search(nums: IntArray, target: Int): Int {
            var left = 0
            var right = nums.size - 1

            while (left <= right) {
                val middle = (left + right) / 2
                if (target == nums[middle]) {
                    return middle
                }

                // Working on the left portion
                if (nums[left] <= nums[middle]) {
                    if (target > nums[middle] || target < nums[left]) {
                        left = middle + 1
                    } else {
                        right = middle - 1
                    }
                } else {
                    if (target < nums[middle] || target > nums[right]) {
                        right = middle - 1
                    } else {
                        left = middle + 1
                    }
                }
            }
            return -1
        }
    }
}