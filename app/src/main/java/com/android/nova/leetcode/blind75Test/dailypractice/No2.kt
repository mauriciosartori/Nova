package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No2 {
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
            val map = HashMap<Int, Int>()

            for (i in 0 until nums.size) {
                val complement = target - nums[i]
                if (map.contains(complement)) {
                    val start = map.getOrDefault(complement, 0)
                    return intArrayOf(start, i)
                }
                map[nums[i]] = i
            }
            return intArrayOf(-1, -1)
        }
    }
}