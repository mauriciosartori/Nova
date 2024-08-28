package com.android.nova.leetcode.blind75Test.dp
/**
 *
 */
class No13 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //val result = canJump(intArrayOf(3, 2, 1, 0, 4))
            val result = canJump(intArrayOf(2,3,1,1,4))
            println("The result for the No 11 is $result")
        }
        fun canJump(nums: IntArray): Boolean {
            val dp = BooleanArray(nums.size){true}
            return findJumps(0, nums, dp)
        }

        fun findJumps(index: Int, nums:IntArray, dp:BooleanArray):Boolean {
            if (index == nums.size - 1) {
                return true
            }
            for (i in 1..nums[index]) {
                if (dp[i + index] == true && findJumps(i + index, nums, dp)) {
                    return true
                } else {
                    dp[i + index] = false
                }
            }
            return false
        }
    }
}