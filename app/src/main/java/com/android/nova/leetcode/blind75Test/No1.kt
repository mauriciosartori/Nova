package com.android.nova.leetcode.blind75Test

import java.util.HashMap

/**
 *
 */
class No1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("No 1")
            //val result = twoSum(intArrayOf(3,2,3), 6)
            //val result = twoSum(intArrayOf(2,7,11,15), 9)
            // val result = twoSum(intArrayOf(3,2,4), 6)
            val result = twoSum(intArrayOf(3,2,4), 6)
            println(result[0])
            println(result[1])

        }

        fun twoSum(nums: IntArray, target: Int): IntArray {

            val mapOcurrences = HashMap<Int, Int>()
            var start = 0
            var end = 0
            for (i in nums.indices) {
                val missedNumber = target - nums[i]
                if (mapOcurrences.containsKey(missedNumber)) {
                    start = mapOcurrences.getOrDefault(missedNumber, 0)
                    end = i
                    break
                }
                mapOcurrences[nums[i]] = i
            }
            return intArrayOf(start, end)
        }
    }
}