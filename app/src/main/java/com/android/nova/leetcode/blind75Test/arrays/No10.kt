package com.android.nova.leetcode.blind75Test.arrays
/**
 *
 */
class No10 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = twoSum(intArrayOf(2,7,11,15),9)
            println("Result ${result.contentToString()}")
        }
        fun twoSum(nums: IntArray, target: Int): IntArray {
            val hashNumberIndex = HashMap<Int, Int>()

            for (i in nums.indices) {
                val number = nums[i]
                val complement = target - number
                if (hashNumberIndex.contains(complement)) {
                    return intArrayOf(hashNumberIndex.getOrDefault(complement, 0),i )
                }
                hashNumberIndex[number] = i
            }
            return intArrayOf(-1,-1)
        }
    }
}