package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No38 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val intervals = arrayOf(
//                intArrayOf(1, 3),
//                intArrayOf(2, 6),
//                intArrayOf(8, 10),
//                intArrayOf(15, 18)
//            )
            val intervals = arrayOf(
                intArrayOf(1, 4),
                intArrayOf(4, 5),
            )

            val mergedIntervals = merge(intervals)
            println(mergedIntervals.joinToString(", ") { "[${it.joinToString(", ")}]" })
        }
        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            val fragIntervals = ArrayList<Pair<Int, Int>>()
            for (inter in intervals) {
                val start = inter[0]
                val end = inter[1]
                fragIntervals.add(Pair(start, 1))
                fragIntervals.add(Pair(end, -1))
            }
            //fragIntervals.sortBy{it.first}
            fragIntervals.sortWith(compareBy({ it.first }, { -it.second }))

            val result = ArrayList<IntArray>()
            var sum = 0
            var start = 0
            var end = 0
            for (index in 0 until fragIntervals.size) {
                val (interval, isStart) = fragIntervals.get(index)
                if (sum == 0) {
                    if (index != 0) {
                        var newInterval = intArrayOf(start, end)
                        result.add(newInterval)
                    }
                    start = interval
                }
                if (isStart == -1) {
                    end = interval
                }
                sum += isStart
            }
            result.add(intArrayOf(start, end))
            return result.toTypedArray()
        }
    }
}