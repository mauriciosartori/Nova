package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No44 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Input intervals
            val intervals: Array<IntArray> = arrayOf(
                intArrayOf(0, 30),
                intArrayOf(5, 10),
                intArrayOf(15, 20)
            )

            // Call the function and print the result
            val canAttend = canAttendMeetings(intervals)
            println("Output: $canAttend") // This will print true or false
        }
        fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
            val interList = mutableListOf<Pair<Int, Boolean>>()

            for (item in intervals) {
                interList.add(Pair(item[0], true))
                interList.add(Pair(item[1], false))
            }
            var count = 0
            for (item in interList) {
                count += if (item.second) 1 else -1
                if (count > 1) {
                    return false
                }
            }

            return true
        }
    }
}