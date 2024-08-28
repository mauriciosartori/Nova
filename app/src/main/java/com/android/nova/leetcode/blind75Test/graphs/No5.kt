package com.android.nova.leetcode.blind75Test.graphs
/**
 *
 */
class No5 {
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
            //canFinish(2, arrayOf(intArrayOf(1,0)))

            println("The result of the no5 is $result")
        }
        fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            val courses = prerequisites
            val adjacentMap = HashMap<Int, ArrayList<Int>>()

            for (relation in courses) {
                val firstItem = relation[0]
                val secondItem = relation[1]
                if (adjacentMap.contains(firstItem)) {
                    adjacentMap[firstItem]?.add(secondItem)
                } else {
                    val nodeList = arrayListOf(secondItem)
                    adjacentMap[firstItem] = nodeList
                }
            }

            val vistedSet = HashSet<Int>()
            return dfs(0, vistedSet, adjacentMap)
        }

        fun dfs(index:Int, vistedSet:HashSet<Int>, adjacentMap:HashMap<Int, ArrayList<Int>>): Boolean {
            if (vistedSet.contains(index)) {
                return false
            }
            if (adjacentMap.get(index)?.size == 0) {
                return true
            }
            vistedSet.add(index)

            for (subIndex in adjacentMap.getOrDefault(index, ArrayList())) {
                if (!dfs(subIndex, vistedSet, adjacentMap)) {
                    return false
                }
            }
            vistedSet.remove(index)
            return true
        }
    }
}