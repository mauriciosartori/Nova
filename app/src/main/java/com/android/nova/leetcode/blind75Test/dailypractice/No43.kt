package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No43 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val intervals: Array<IntArray> = arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18)
            )
            println(intervals.contentDeepToString())
            println("Andas")
            println(merge(intervals).contentDeepToString())
        }
        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            val intervalsList = mutableListOf<Pair<Int, Boolean>>()

            for (item in intervals) {
                val start = item[0]
                val end = item[1]
                intervalsList.add(Pair(start, true))
                intervalsList.add(Pair(end, false))
            }

            intervalsList.sortWith(compareBy({it.first}, {!it.second}))

            val result = mutableListOf<IntArray>()
            var count = 0
            var indexStart = 0

            for ((index, item) in intervalsList.withIndex()) {
                if (index != 0 && count == 0) {
                    val itemResult = IntArray(2)
                    itemResult[0] = intervalsList[indexStart].first
                    itemResult[1] = intervalsList[index - 1].first
                    result.add(itemResult)
                    indexStart =index
                }
                if (item.second) {
                    count++
                } else {
                    count--
                }
            }

            val itemResult = IntArray(2)
            itemResult[0] = intervalsList[indexStart].first
            itemResult[1] = intervalsList[intervalsList.size - 1].first
            result.add(itemResult)
            return result.toTypedArray()
        }
    }
}