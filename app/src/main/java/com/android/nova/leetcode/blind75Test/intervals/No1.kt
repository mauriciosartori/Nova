package com.android.nova.leetcode.blind75Test.intervals
/**
 *
 */
class No1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            [[1,3],[6,9]]
//            newInterval =
//                [2,5]
            val intervals: Array<IntArray> = arrayOf(intArrayOf(1,3), intArrayOf(6,9))

            val result = insert(intervals, intArrayOf(2, 5))
            println("The result of No 1 is ${result.contentDeepToString()}")
        }
        fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            val newIntervalStart = newInterval[0]
            val newIntervalEnd = newInterval[1]

            val result = ArrayList<IntArray>()
            var newIntervalFound = false
            var newStartFound = 0
            for ((currentStart, currentEnd) in intervals) {
                if (newIntervalStart < currentEnd && !newIntervalFound) {
                    newIntervalFound = true
                    newStartFound = currentStart
                    continue
                }
                if (currentStart > newIntervalEnd && newIntervalFound) {
                    result.add(intArrayOf(newStartFound,newIntervalEnd))
                    result.add(intArrayOf(currentStart, currentEnd))
                    newIntervalFound = false
                } else if (currentStart == newIntervalEnd && newIntervalFound) {
                    result.add(intArrayOf(newStartFound, currentEnd))
                    newIntervalFound = false
                } else {
                    result.add(intArrayOf(currentStart, currentEnd))
                }

            }

            return result.toTypedArray()
        }
    }
}