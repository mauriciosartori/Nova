package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No24 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = climbStairs(3)
            println("The result of 24 is $result")
        }
    fun climbStairs(n: Int): Int {
        var target = n
        val queue = ArrayDeque<Pair<Int, Int>>()
        var count = 0
        queue.add(Pair(0, 0))

        while (!queue.isEmpty()) {

            val numPair = queue.removeFirst()
            val numVal = numPair.first
            val numSum = numPair.second
            if (numSum > target) {
                continue
            }
            if (numSum == target) {
                count++
            }
            queue.add(Pair(1, numSum + 1))
            queue.add(Pair(2, numSum + 2))
        }
        return count
    }
    }
}