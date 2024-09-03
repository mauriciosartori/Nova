package com.android.nova.leetcode.blind75Test.intervals
/**
 *
 */
class No4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val intervals: Array<IntArray> = arrayOf(
                intArrayOf(1, 100),
                intArrayOf(11, 22),
                intArrayOf(1, 11),
                intArrayOf(2, 12)
            )
            val result = eraseOverlapIntervals(intervals)
            println("the result for No4 is $result")
        }

        fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
            val listIntervals = ArrayList<Pair<Int, Boolean>>()


            for (interval in intervals) {
                listIntervals.add(Pair(interval[0], true))
                listIntervals.add(Pair(interval[1], false))
            }
            listIntervals.sortWith(compareBy({it.first}))

            var maxOverlapping = 0
            var count = 0

            for (intervalState in listIntervals) {
                val currentValue = intervalState.first
                val isStart = intervalState.second
                maxOverlapping = maxOf(maxOverlapping, count)

                if (isStart) {
                    count++
                } else {
                    count--
                }
            }

            return maxOverlapping - 1
        }
    }
}