package com.android.nova.leetcode.blind75Test.dp
/**
 *
 */
class No10 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //val result = canJump(intArrayOf(2,3,1,1,4))
            val result = canJump(intArrayOf(3,2,1,0,4))

            println("The result for the No 10 is $result")
        }

        fun canJump(nums: IntArray): Boolean {
            val dp = BooleanArray(nums.size){false}
            return findJumps(0, nums, dp)
        }

        fun findJumps(index:Int, nums: IntArray, dp:BooleanArray): Boolean {
            if (index > nums.size - 1 || nums[index] == 0 || dp[index] == false) {
                return false
            }
            if (index == nums.size - 1) {
                return true
            }

            for (i in index..< nums.size) {
                val currentValue = nums[i]
                for (j in (i + 1)..(i + currentValue)) {
                    val result = findJumps(j, nums, dp)
                    if (result == true) {
                        return true
                    } else {
                        if (j < nums.size) {
                            dp[j] = false
                        }
                    }
                }
            }
            return false
        }
    }
}