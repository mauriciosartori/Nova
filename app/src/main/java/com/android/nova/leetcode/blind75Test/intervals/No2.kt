package com.android.nova.leetcode.blind75Test.intervals
/**
 *
 */
class No2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val intervals: Array<IntArray> = arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3, 5),
                intArrayOf(6, 7),
                intArrayOf(8, 10),
                intArrayOf(12, 16)
            )
            val result = insert(intervals, intArrayOf(4,8))
            println("The result of No 1 is ${result.contentDeepToString()}")
        }
        fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            var tempInterval = newInterval
            val result = ArrayList<IntArray>()
            val newStart = newInterval[0]
            val newEnd = newInterval[1]

            var i = -1
            while (i < intervals.size){
                i++
                val currentEnd = intervals[i][1]
                if (newStart < currentEnd) {
                    tempInterval[0] = minOf(newStart,intervals[i][0] )
                    break
                } else {
                    result.add(intervals[i])
                }
            }

            while (i < intervals.size){
                val currentEnd = intervals[i][1]
                val currentStart = intervals[i][0]
                if (tempInterval[1] < currentEnd) {
                    tempInterval[0] = minOf(currentStart,tempInterval[0] )
                    tempInterval[1] = maxOf(currentEnd,tempInterval[1] )
                    i++
                    break
                }
                i++
            }

            result.add(tempInterval)
            while (i < intervals.size){
                result.add(intervals[i])
                i++
            }

            return result.toTypedArray()
        }
    }
}