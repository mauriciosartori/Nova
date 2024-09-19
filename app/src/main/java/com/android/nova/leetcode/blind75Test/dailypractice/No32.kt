package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No32 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val edges = arrayOf(
//                intArrayOf(0, 1),
//                intArrayOf(0, 2),
//                intArrayOf(0, 3),
//                intArrayOf(1, 4)
//            )
//            val edges = arrayOf(
//                intArrayOf(0, 1),
//                intArrayOf(1, 2),
//                intArrayOf(2, 3),
//                intArrayOf(1, 3),
//                intArrayOf(1, 4)
//            )
//            val n = 5
            val edges = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(2, 3),
            )
            val n = 4
            val result = validTree(n, edges)
            println("Is the graph a valid tree? $result")
        }
        fun validTree(n: Int, edges: Array<IntArray>): Boolean {

            val memo = IntArray(n - 1)
            val mapEdges = HashMap<Int, ArrayList<Int>>()

            fun dfs(nodeInfo: Pair<Int, Int>): Boolean {
                val (node, parent) = nodeInfo
                if (memo[node] == 2) {
                    return true
                }
                if (memo[node] == 1) {
                    return false
                }
                memo[node] = 1
                val listNeigbors = mapEdges.getOrDefault(node, ArrayList())
                for (nei in listNeigbors) {
                    if (nei == parent) {
                        continue
                    }
                    val result = dfs(Pair(nei, node))
                    if (!result) {
                        return false
                    }
                }
                memo[node] = 2
                return true
            }


            for (edge in edges) {
                mapEdges.getOrPut(edge[0]){ArrayList()}.add(edge[1])
                mapEdges.getOrPut(edge[1]){ArrayList()}.add(edge[0])
            }

            val result = dfs(Pair(edges[0][0], -1))
            return result
        }
    }
}