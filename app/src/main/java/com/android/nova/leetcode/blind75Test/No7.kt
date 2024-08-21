package com.android.nova.leetcode.blind75Test

/**
 *
 */
class No7 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Andas")
            //val result = findMin(intArrayOf(3,4,5,1,2))
            //val result = findMin(intArrayOf(4, 5, 6, 7, 0, 1, 2))
            //val result = findMin(intArrayOf(11,13,15,17))
            //val result = findMin(intArrayOf(1,2))
            val result = findMin(intArrayOf(2,1))

            print("Lo hecho $result")
        }

        fun findMin(nums: IntArray): Int {
            var left = 0
            var right = nums.size - 1
            while (left < right) {
                val middle = (left + right) / 2
                if (nums[middle] > nums[right]) {
                    left = middle + 1
                } else {
                    right = middle
                }
            }
            return nums[left]
        }
    }
}