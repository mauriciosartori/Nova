package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No37 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            val size = intervals.size
            var i = 0
            val result = ArrayList<IntArray>()

            while (i < size) {
                val interval = intervals[i]
                val start = interval[0]
                var end = interval[1]
                var newInterval = IntArray(2)
                var nextinterval = intervals[i + 1]

                while (nextinterval[0] <= end) {
                    if (i + 1 == size) {
                        break
                    }
                    nextinterval = intervals[i + 1]
                    end = nextinterval[1]
                    i++
                }

                newInterval[0] = start
                newInterval[1] = end
                result.add(newInterval)
                i++
            }
            return result.toTypedArray()
        }
    }
}