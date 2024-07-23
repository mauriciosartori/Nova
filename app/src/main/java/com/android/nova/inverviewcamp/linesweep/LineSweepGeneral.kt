package com.android.nova.inverviewcamp.linesweep
/**
 * 1. (Level: Medium)
 * Given a list of time intervals,
 * find if any of them overlap.
 * Each interval has a start time and a stop time.
 *
 * For example,Intervals -> [5,7], [1,3], [6,9] -> Intervals [5,7] and [6,9]overlap, so we return true
 */
class LineSweepGeneral {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray:Array<IntArray> = arrayOf(
                intArrayOf(5,7),
                intArrayOf(1,3),
                intArrayOf(6,9)
            )
            println("Processing the intervals...")
            processingIntervals(inputArray)
        }

        fun processingIntervals(inputArray: Array<IntArray>) {
            val listIntervals = ArrayList<TimeInterval>()
            for (intervalArray in inputArray) {
                val startTime = intervalArray.first()
                val endTime = intervalArray.last()
                listIntervals.add(TimeInterval(startTime, true))
                listIntervals.add(TimeInterval(endTime, false))
            }
            listIntervals.sortBy { it.time }

            var count = 0
            println("The times list sorted is ")
            for (interval in listIntervals) {
                print("${interval.time}, ")
                count = if (interval.isStartTime) count + 1 else count - 1
                println("count value $count")
                if (count > 1) {
                    println("There is an interval with two schedules at the same time")
                }
            }
            println(" ")
        }
    }

    private class TimeInterval (var time: Int, var isStartTime: Boolean )
}