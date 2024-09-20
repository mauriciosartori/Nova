package com.android.nova.leetcode.blind75Test.dailypractice

/**
 *
 */
class No35 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val N = 10L
//            val K = 1L
//            val M = 2
//            val S = arrayOf(2L, 6L)
//
//            val result = No35.getMaxAdditionalDinersCount(N, K, M, S)
//            println("Maximum additional diners count: $result")

            val N = 15L
            val K = 2L
            val M = 3
            val S = arrayOf(11L, 6L, 14L)

            val result = No35.getMaxAdditionalDinersCount(N, K, M, S)
            println("Maximum additional diners count: $result")
        }

        fun getMaxAdditionalDinersCount(N: Long, K: Long, M: Int, S: Array<Long>): Long {
            val dinersList = S
            dinersList.sort()
            var start = 0L
            val spacesList = mutableListOf<Long>()
            var lastIndex = 0
            for (diner in dinersList) {
                spacesList.add(diner - start)
                start = diner + 1
                lastIndex = diner.toInt()
            }

            if (lastIndex != N.toInt() - 1 ) {
                spacesList.add(((N.toInt() - 1) - lastIndex).toLong())
            }

            if (!spacesList.isEmpty()) {
                spacesList[0] += K
                spacesList[spacesList.size - 1] += K
            }

            var result = 0L
            val minSpace = (K * 2) + 1
            for (spaceAvailable in spacesList) {
                if (spaceAvailable < minSpace) {
                    continue
                } else if (spaceAvailable == minSpace) {
                    result++
                } else {
                    val remind = spaceAvailable.toInt() % minSpace.toInt()
                    if (remind != 0) {
                        val available = (spaceAvailable + 1) / minSpace
                        result += available.toLong()
                    } else {
                        val available = (spaceAvailable) / minSpace
                        result += available.toLong()
                    }
                }
            }

            return result
        }
    }
}