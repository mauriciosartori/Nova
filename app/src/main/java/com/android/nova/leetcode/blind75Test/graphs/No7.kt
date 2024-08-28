package com.android.nova.leetcode.blind75Test.graphs

import java.util.LinkedList


/**
 *
 */
class No7 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val heights = arrayOf(
                intArrayOf(1, 2, 2, 3, 5),
                intArrayOf(3, 2, 3, 4, 4),
                intArrayOf(2, 4, 5, 3, 1),
                intArrayOf(6, 7, 1, 4, 5),
                intArrayOf(5, 1, 1, 2, 4)
            )
            pacificAtlantic(heights)
            println("")
        }
        //fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        fun pacificAtlantic(heights: Array<IntArray>) {
            val rows = heights.size
            val cols = heights[0].size
            // Create a queue and set of left and top
            val queuePac = LinkedList<Pair<Int, Int>>()
            val setPac = HashSet<Pair<Int, Int>>()
            // Add the top
            for (i in 0..<cols) {
                queuePac.add(Pair(0, i))
                setPac.add(Pair(0, i))
            }
            // Add left
            for (j in 1..<rows) {
                queuePac.add(Pair(j, 0))
                setPac.add(Pair(j, 0))
            }

            // Create a queue and set of right and bottom
            val queueAtl = LinkedList<Pair<Int, Int>>()
            val setAtl = HashSet<Pair<Int, Int>>()
            // Add the bottom
            for (i in 0..<cols) {
                queueAtl.add(Pair(rows - 1, i))
                setAtl.add(Pair(rows - 1, i))
            }
            // Add right
            for (j in 0..<rows -1 ) {
                queueAtl.add(Pair(j, cols - 1))
                setAtl.add(Pair(j, cols - 1))
            }
            bfs(queuePac, rows, cols, setPac, heights)

            val resultSet = setAtl.intersect(setPac)
            val resultList = ArrayList<List<Int>>()

            for (pair in resultSet) {
                resultList.add(arrayListOf(pair.first, pair.second))
                println("${pair.first}, ${pair.second}")
            }
        }

        fun bfs(queue: LinkedList<Pair<Int, Int>>, rows: Int, cols: Int, setItemsUsed: HashSet<Pair<Int, Int>>, heights: Array<IntArray>) {
            val nextCoordinatesArray = arrayOf(intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1),)
            while (!queue.isEmpty()) {
                val currentCoordinate = queue.remove()
                for (nextCoorValues in nextCoordinatesArray) {
                    val nextRow = currentCoordinate.first + nextCoorValues[0]
                    val nextCol = currentCoordinate.second + nextCoorValues[1]
                    if (nextRow >= 0 && nextCol >= 0 && nextRow < rows && nextCol < cols) {
                        if (setItemsUsed.contains(Pair(nextRow, nextCol))) {
                            continue
                        }
                        if (heights[nextRow][nextCol] >= heights[currentCoordinate.first][currentCoordinate.second]) {
                            setItemsUsed.add(Pair(nextRow, nextCol))
                            queue.add(Pair(nextRow, nextCol))
                        }
                    }
                }
            }
        }
    }
}