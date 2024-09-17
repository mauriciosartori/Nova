package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No23 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Define the input array
            //val input = intArrayOf(-1, 0, 1, 2, -1, -4)
            val input = intArrayOf(0, 0, 0, 0)

            // Call the threeSum function with the input
            val result = threeSum(input)

            // Print the result
            println("Three Sum Results: $result")
        }

        fun threeSum(nums: IntArray): List<List<Int>> {
            nums.sort()
            var prev = Integer.MAX_VALUE
            val result = mutableListOf<List<Int>>()

            for (i in nums.indices) {
                val target = nums[i]
                if (target == prev) {
                    continue
                }
                prev = target

                var start = i + 1
                var end = nums.size - 1
                var prevStart = Integer.MAX_VALUE
                while (start < end) {
                    val sum = target + nums[start] + nums[end]
                    if (sum > 0) {
                        end--
                    } else if (sum < 0) {
                        start++
                    } else {
                        if (nums[start] != prevStart) {
                            val combination = mutableListOf(nums[i], nums[start], nums[end])
                            result.add(combination)
                        }
                        prevStart = nums[start]
                        start++
                    }
                }
            }
            return result
        }
    }
}