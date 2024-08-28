package com.android.nova.leetcode.blind75Test.graphs
/**
 *
 */
class No3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //val result = canFinish(1, Array(1){intArrayOf(1,0)})
            val result = canFinish(1, arrayOf<IntArray>())
            println("The result is $result")
        }
        fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            val memo = HashSet<Pair<Int, Int>>()

            return dfs(0, numCourses, prerequisites, memo)
        }

        fun dfs(index:Int, numCourses: Int, prerequisites: Array<IntArray>, memo: HashSet<Pair<Int, Int>>): Boolean {
            if (prerequisites.size == 0) {
                return false
            }
            val lastCorse = prerequisites[index][0]
            val firstCorse = prerequisites[index][1]

            val possibleLoop = Pair(lastCorse, firstCorse)

            if (memo.contains(possibleLoop)) {
                return false
            }

            val newPair = Pair(firstCorse, lastCorse)
            memo.add(newPair)
            if (index + 1 <= prerequisites.size - 1) {
                 val result = dfs(index + 1, numCourses, prerequisites, memo)
                if (!result) {
                    return result
                }
            }
            return true
        }



    }
}