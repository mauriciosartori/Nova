package com.android.nova.leetcode.blind75Test.graphs
/**
 *
 */
class No4 {
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
            // Little test on HashSet
            val testElement = Pair(0,0)
            memo.add(testElement)
            println("----------------------")
            println("Does the element exist")
            println(memo.contains(Pair(0,1)))
            println("----------------------")
            return true
        }



    }
}