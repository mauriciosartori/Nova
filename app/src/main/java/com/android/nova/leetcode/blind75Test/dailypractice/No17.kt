package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No17 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val N: Long = 10
//            val K: Long = 1
//            val M: Int = 2
//            val S: Array<Long> = arrayOf(2, 6)

            val N: Long = 15
            val K: Long = 2
            val M: Int = 3
            val S: Array<Long> = arrayOf(11, 6, 14)

            val result = getMaxAdditionalDinersCount(N, K, M, S)
            println("Result: $result")
        }
        fun getMaxAdditionalDinersCount(N: Long, K: Long, M: Int, S: Array<Long>): Long {
            S.sort()
            val seatsOccupied = S.plus(N)
            val minSpace = K.toInt()
            var lastSeat = 0
            val minSpaceNeeded = 1 + minSpace + minSpace
            var result = 0

            for ((index, seatL) in seatsOccupied.withIndex()) {
                val seat = seatL.toInt()
                var availableSpace = 0

                availableSpace = seat - lastSeat - 1

                // check if seat if beginig or last
                if (seat == 1 || seat == N.toInt()) {
                    availableSpace += minSpace + 1
                }
                lastSeat = seat

                if (availableSpace >= minSpaceNeeded) {
                    val spaces = (availableSpace + 1) / minSpaceNeeded
                    result += spaces
                }
            }
            return result.toLong()
        }
    }
}