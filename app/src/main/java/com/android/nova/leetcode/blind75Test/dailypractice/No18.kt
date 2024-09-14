package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No18 {
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
            val seatsTaken = S
            var spaceAvailble = 0L
            var prevSeat = 0L
            var result = 0L
            val length = (2 * K) + 1

            for (seatIndex in seatsTaken) {
                spaceAvailble = seatIndex - (prevSeat + 1) - 2 * K
                if (spaceAvailble > 0) {
                    result += 1
                    val extra = (spaceAvailble - 1) / length
                    result += extra
                }
                prevSeat = seatIndex
            }
            spaceAvailble = (N + 1) - (prevSeat + 1) - K
            if (spaceAvailble > 0) {
                result += 1
                val extra = (spaceAvailble ) / length
                result += extra
            }

            return result
        }
    }
}