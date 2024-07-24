package com.android.nova.inverviewcamp.linesweep
/**
 * 1. (Level: Medium)
 * Given a list of time intervals,
 * find if any of them overlap.
 * Each interval has a start time and a stop time.
 *
 * For example,Intervals -> [5,7], [1,3], [6,9] -> Intervals [5,7] and [6,9]overlap, so we return true
 */
class LineSweepGeneral1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray: Array<IntArray> = arrayOf(
                intArrayOf(5, 7),
                intArrayOf(1, 3),
                intArrayOf(8, 9)
            )
            println("Processing the intervals...")
            processingIntervals(inputArray)
        }

        fun processingIntervals(inputArray: Array<IntArray>) {
            val listIntervals = ArrayList<SingleInterval>()
            for (interval in inputArray) {
                val start = interval[0]
                val end = interval[1]

                listIntervals.add(SingleInterval(start, true))
                listIntervals.add(SingleInterval(end, false))
            }

            listIntervals.sortBy { it.value }

            var count = 0
            for (item in listIntervals) {
                count = if (item.isStartInterval) count + 1 else count - 1
                if (count > 1) {
                    println("There is an overlap here")
                    return
                }
            }
            println("For this case there is not overlap at all")
        }

    }

    private class SingleInterval(val value: Int, val isStartInterval: Boolean)
}