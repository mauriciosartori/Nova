package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No22 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Define the input array
            val input = intArrayOf(-1, 0, 1, 2, -1, -4)


            // Call the threeSum function with the input
            val result = threeSum(input)

            // Print the result
            println("Three Sum Results: $result")
        }

        fun threeSum(nums: IntArray): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            val mapMemo = HashSet<List<Int>>()

            fun findCombination(index: Int, bufIndex: Int,  buffer: IntArray, sum: Int) {
                if (bufIndex == 3) {
                    if (sum == 0) {
                        val combination = mutableListOf<Int>()
                        combination.add(buffer[0])
                        combination.add(buffer[1])
                        combination.add(buffer[2])
                        combination.sort()
                        if (!mapMemo.contains(combination)) {
                            result.add(combination)
                            mapMemo.add(combination)
                        }
                    }
                    return
                }
                if (index < 0) {
                    return
                }

                for (i in index until nums.size) {
                    buffer[bufIndex] = nums[i]
                    findCombination(i + 1, bufIndex + 1, buffer, sum + nums[i])
                }
            }

            findCombination(0, 0, IntArray(3), 0)
            return result
        }
    }
}