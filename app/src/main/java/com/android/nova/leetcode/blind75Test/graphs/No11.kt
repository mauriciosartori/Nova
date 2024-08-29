package com.android.nova.leetcode.blind75Test.graphs
/**
 *
 */
class No11 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val edges: Array<IntArray> = arrayOf(
//                intArrayOf(0, 1),
//                intArrayOf(1, 2),
//                intArrayOf(2, 3),
//                intArrayOf(1, 3),
//                intArrayOf(1, 4)
//            )

//            val edges: Array<IntArray> = arrayOf(
//                intArrayOf(0, 1),
//                intArrayOf(0, 2),
//                intArrayOf(0, 3),
//                intArrayOf(1, 4)
//            )
            val edges: Array<IntArray> = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(2, 3),
            )
            val result = validTree(4, edges)
            println("The result for No10 is $result")
        }

        fun validTree(n: Int, edges: Array<IntArray>): Boolean {
            val adjacentMap = HashMap<Int, ArrayList<Int>>()

            for (edge in edges) {
                val key = edge[0]
                val value = edge[1]
                adjacentMap.getOrPut(key){ArrayList()}.add(value)
                adjacentMap.getOrPut(value){ArrayList()}.add(key)
            }

            val stateMap = HashMap<Int, Int>()
            for (i in 0..n-1) {
                stateMap[i] = 0
            }
            val result = !dfs(0, stateMap, adjacentMap, -1)
            return result && stateMap.values.none { it == 0 }
        }

        fun dfs(index:Int, stateMap: HashMap<Int, Int>, adjacentMap: HashMap<Int, ArrayList<Int>>, prevIndex: Int): Boolean {
            if (stateMap[index] == 2) {
                return false
            }
            if (stateMap[index] == 0) {
                stateMap[index] = 1
            }

            val listEdges = adjacentMap.getOrDefault(index, ArrayList())
            for (nei in listEdges) {
                if (nei != prevIndex && stateMap[nei] == 0 && dfs(nei, stateMap, adjacentMap, index)) {
                    return true
                } else if (nei != prevIndex && stateMap[nei] == 1) {
                    return true
                }
            }
            stateMap[index] = 2
            return false
        }
    }
}