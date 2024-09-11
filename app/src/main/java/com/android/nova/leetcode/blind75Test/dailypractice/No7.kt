package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No7 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val N: Long = 10
            val K: Long = 1
            val M: Int = 2
            val S: Array<Long> = arrayOf(2, 6)

            val result = getMaxAdditionalDinersCount(N, K, M, S)
            println("Maximum additional diners count: $result")
        }

        fun getMaxAdditionalDinersCount(N: Long, K: Long, M: Int, S: Array<Long>): Long {
            S.sort()
            val seats = S
            val tableArray = IntArray(N.toInt())

            for (index in 0 until seats.size) {
                val seatIndex = seats[index].toInt()
                // Adding dinner person
                tableArray[seatIndex] = 9

                for (leftIndex in 1..K.toInt()) {
                    if (seatIndex - leftIndex < 0) {
                        break
                    }
                    if (tableArray[seatIndex - leftIndex] != 9) {
                        tableArray[seatIndex - leftIndex] = 5
                    }
                }

                for (rightIndex in 1..K.toInt()) {
                    if (seatIndex + rightIndex >= tableArray.size){
                        break
                    }
                    if (tableArray[seatIndex + rightIndex] != 9) {
                        tableArray[seatIndex + rightIndex] = 5
                    }

                }
            }

            var diners = 0

            var index = 0
            while(index < tableArray.size) {
                if (tableArray[index] == 0) {
                    var enoughSpace = true
                    for (rightIndex in 1..K) {
                        if (index + rightIndex >= tableArray.size) {
                            enoughSpace = false
                            break
                        }
                        if (tableArray[(index + rightIndex).toInt()] == 9){
                            enoughSpace = false
                            break
                        }
                    }
                    if (enoughSpace) {
                        index = (index + K).toInt() + 1
                        diners = diners + 1
                        continue
                    }
                }
                index++
            }


            return diners.toLong()
        }
    }
}