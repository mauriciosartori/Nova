package com.android.nova.leetcode.blind75Test.graphs

import java.util.LinkedList

/**
 *
 */
class No10 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val edges: Array<IntArray> = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4)
            )

            val result = countComponents(5, edges)
            println("The result for No 10 is $result")
        }
        fun countComponents(n: Int, edges: Array<IntArray>): Int {
            val edgesMemoMap = HashMap<Int, ArrayList<Int>>()
            for (edge in edges) {
                edgesMemoMap.getOrPut(edge[0]){ArrayList()}.add(edge[1])
                //edgesMemoMap.getOrPut(edge[1]){ArrayList()}.add(edge[0])
            }

            var result = 0
            val visitedSet = HashSet<Int>()
            for (i in 0..< n) {
                if (!visitedSet.contains(i)) {
                    bfs(i, edgesMemoMap,visitedSet )
                    result++
                }
            }


            return result
        }

        fun bfs(index: Int, edgesMemoMap:HashMap<Int, ArrayList<Int>> , visitedSet:HashSet<Int>) {
            val queue = LinkedList<Int>()
            queue.add(index)

            while (!queue.isEmpty()) {
                val currentIndex = queue.remove()
                val listNeighbors = edgesMemoMap.getOrDefault(currentIndex, ArrayList())
                for (nei in listNeighbors) {
                    if (!visitedSet.contains(nei)) {
                        visitedSet.add(nei)
                        queue.add(nei)
                    }
                }
            }
        }
    }
}