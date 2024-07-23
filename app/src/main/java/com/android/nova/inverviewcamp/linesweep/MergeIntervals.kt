package com.android.nova.inverviewcamp.linesweep
/**
 * 1. Merge Intervals -
 * Given a list of intervals, merge all overlapping intervals.
 * At the end of the merge, there should be no overlapping intervals.
 *
 * For example,
 * Input = (1,3), (3,5), (6,8), (7,9)
 * Output = (1,5), (6,9)
 */
class MergeIntervals {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray:Array<IntArray> = arrayOf(
                intArrayOf(1, 3),
                intArrayOf(3, 5),
                intArrayOf(6, 8),
                intArrayOf(7, 9),
            )
            println("Looking to merge intervals that overlap")
            mergeIntervals(inputArray)
        }

        fun mergeIntervals(inputArray: Array<IntArray>) {
            val listIntervals = ArrayList<IntervalTime>()
            for (intervalItem in inputArray) {
                val startTime = intervalItem.first()
                val endTime = intervalItem.last()

                listIntervals.add(IntervalTime(startTime, true))
                listIntervals.add(IntervalTime(endTime, false))
            }

            listIntervals.sortBy { it.time }

            var startInterval: Int? = null
            var count = 0
            for (item in listIntervals) {
                if (item.isStartTime) {
                    count = count + 1
                    if (count == 1) {
                        startInterval = item.time
                    }
                } else {
                    count = count - 1
                    if (count == 0) {
                        println("This interval is $startInterval and  ${item.time}")
                    }
                }

            }
        }
    }
    private class IntervalTime(val time: Int, val isStartTime: Boolean)

}