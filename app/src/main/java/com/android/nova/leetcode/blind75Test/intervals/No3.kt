package com.android.nova.leetcode.blind75Test.intervals
/**
 *
 */
class No3 {
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
            val intervalsList = ArrayList<Pair<Int, Boolean>>()
            for (item in intervals) {
                val start = item[0]
                val end = item[1]
                intervalsList.add(Pair(start, true))
                intervalsList.add(Pair(end, false))
            }
            intervalsList.add(Pair(newInterval[0], true))
            intervalsList.add(Pair(newInterval[1], false))

            // intervalsList.sort()
            // Sort by the integer value; if the values are equal, sort by the Boolean (start=true before end=false)
            intervalsList.sortWith(compareBy({ it.first }, { !it.second }))

            val resultList = ArrayList<IntArray>()

            var count = 0
            var currentStart = 0
            for (pairInterval in intervalsList) {
                val currentValue = pairInterval.first
                val isStart = pairInterval.second
                if (count == 0) {
                    currentStart = currentValue
                }
                if (!isStart &&  count == 1) {
                    val arrayItem = intArrayOf(currentStart, currentValue)
                    resultList. add(arrayItem)
                }
                if (isStart) {
                    count++
                } else {
                    count--
                }
            }
            return resultList.toTypedArray()
        }
    }
}