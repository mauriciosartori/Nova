package com.android.nova.leetcode.blind75Test.intervals
/**
 *
 */
class No5 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // [[13,15],[1,13]]
            val intervals = arrayOf(intArrayOf(13,15), intArrayOf(1,13))
            val result = canAttendMeetings(intervals)
            println("The result to No5 is $result ")
        }
        fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
            val listIntervals = ArrayList<Pair<Int, Boolean>>()
            for (interval in intervals) {
                listIntervals.add(Pair(interval[0], true))
                listIntervals.add(Pair(interval[1], false))
            }

            listIntervals.sortWith(compareBy({it.first}, {it.second}))
            var count = 0
            for (singleInterval in listIntervals) {
                val currentValue = singleInterval.first
                val isStart =  singleInterval.second
                if (count > 1) {
                    return false
                }

                if (isStart) {
                    count++
                } else {
                    count--
                }
            }
            return true
        }
    }
}