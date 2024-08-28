package com.android.nova.leetcode.blind75Test.graphs
/**
 *
 */
class No6 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val prerequisites = arrayOf(
                intArrayOf(0, 10),
                intArrayOf(3, 18),
                intArrayOf(5, 5),
                intArrayOf(6, 11),
                intArrayOf(11, 14),
                intArrayOf(13, 1),
                intArrayOf(15, 1),
                intArrayOf(17, 4)
            )
            val result = canFinish(20, prerequisites)
            //val result = canFinish(2, arrayOf(intArrayOf(1,0)))
            //val result = canFinish(2, arrayOf(intArrayOf(1,0), intArrayOf(0,1)))
            //val result = canFinish(2, arrayOf(intArrayOf(0,1)))
            println("The result of the no5 is $result")
        }

        fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            val courses = prerequisites
            val memo = HashMap<Int, ArrayList<Int>>()
            val stateMap = HashMap<Int, Int>()

            for (currentPosition in courses) {
                val firstCourse= currentPosition[0]
                val secondCourse= currentPosition[1]
                memo.getOrPut(firstCourse){ ArrayList<Int>()}.add(secondCourse)
            }
            for (i in 0..numCourses - 1) {
                stateMap[i] = 0
            }
            for ((key, arrayValues) in memo) {
                if (dfs(key, memo, stateMap)) {
                    return false
                }
            }
            return true
        }

        fun dfs(index:Int, memo:HashMap<Int, ArrayList<Int>>, stateMap: HashMap<Int, Int>): Boolean {
            if (stateMap.get(index)== 2) {
                return false
            }
            if (stateMap.get(index)== 0) {
                stateMap[index] = 1
            }

            val neighbors = memo.getOrDefault(index, ArrayList())

            for (nei in neighbors) {
                if (stateMap.get(nei) == 0 && dfs(nei, memo, stateMap)) {
                    return true
                } else if (stateMap[nei] == 1) {
                    return true
                }
            }
            stateMap[index] = 2
            return false
        }
    }

}