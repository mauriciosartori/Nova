package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No31 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val edges = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(0, 3),
                intArrayOf(1, 4)
            )
//            val edges = arrayOf(
//                intArrayOf(0, 1),
//                intArrayOf(1, 2),
//                intArrayOf(2, 3),
//                intArrayOf(1, 3),
//                intArrayOf(1, 4)
//            )
            val n = 5
            val result = validTree(n, edges)
            println("Is the graph a valid tree? $result")
        }
        fun validTree(n: Int, edges: Array<IntArray>): Boolean {
            val edgesMap = HashMap<Int, MutableList<Int>>()
            val memo = IntArray(n)
            for (edge in edges) {
                edgesMap.getOrPut(edge[0]){mutableListOf()}.add(edge[1])
                edgesMap.getOrPut(edge[1]){mutableListOf()}.add(edge[0])
            }

            val queue = ArrayDeque<Pair<Int, Int>>()
            queue.add(Pair(edges[0][0], -1))

            while (!queue.isEmpty()) {
                val (node, parent) = queue.removeFirst()
                if (memo[node] == 2) {
                    return false
                }
                memo[node] = 1
                val listNeighbors = edgesMap.getOrDefault(node, mutableListOf())
                for (nei in listNeighbors) {
                    if (nei == parent) {
                        continue
                    }
                    if (memo[nei] == 1) {
                        return false
                    }
                    queue.add(Pair(nei, node))
                }
                memo[node] = 2
            }
            return true
        }
    }
}