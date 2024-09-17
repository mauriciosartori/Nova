package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No21 {
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

            val solution = Solution()
            val result = solution.pacificAtlantic(heights)
            println("Coordinates of  Pacific and Atlantic: ")
            println(result)
        }
        class Solution {
            fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
                val board = heights
                val rows = heights.size
                val cols = heights[0].size

                fun bfs(row: Int, col: Int, startValue: Int, nextMove: Pair<Int, Int>): Boolean {
                    val startCoordinate = Pair(row, col)
                    val queue = ArrayDeque<Pair<Int, Int>>()
                    queue.add(startCoordinate)
                    var prevValue = startValue

                    while (!queue.isEmpty()) {
                        val currentCoordinate = queue.removeFirst()
                        val cRow = currentCoordinate.first
                        val cCol = currentCoordinate.second
                        val cValue = board[cRow][cCol]
                        if (cValue > prevValue && cValue >= startValue) {
                            return false
                        }
                        prevValue = cValue

                        val nRow = cRow + nextMove.first
                        val nCol = cCol + nextMove.second
                        if (nRow < rows && nCol < cols && nRow >= 0 && nCol >= 0) {
                            queue.add(Pair(nRow, nCol))
                        }

                    }

                    return true
                }

                val setPDTIslands = HashSet<Pair<Int, Int>>()
                var nextMoves = arrayOf(Pair(0, 1), Pair(1, 0))

                for (row in 0 until rows) {
                    for (col in 0 until cols) {
                        if (row == 1 && col == 4) {
                            println("Baila")
                        }
                        val reachAtlantic = bfs(row, col, board[row][col], nextMoves[0])
                        val atlanticSecond = bfs(row, col, board[row][col], nextMoves[1])
                        if (reachAtlantic || atlanticSecond) {
                            setPDTIslands.add(Pair(row, col))
                        }
                    }
                }

                nextMoves = arrayOf(Pair(-1, 0), Pair(0, -1))
                val result = mutableListOf<List<Int>>()
                for (coordinate in setPDTIslands) {
                    val cRow = coordinate.first
                    val cCol = coordinate.second
                    if (cRow == 1 && cCol == 4) {
                        println("Baila")
                    }
                    val reachAtlantic = bfs(cRow, cCol, board[cRow][cCol], nextMoves[0])
                    val reachAtlanticDos = bfs(cRow, cCol, board[cRow][cCol], nextMoves[1])
                    if (reachAtlantic || reachAtlanticDos) {
                        val island = mutableListOf(cRow, cCol)
                        result.add(island)
                    }
                }
                val sortedPairs = result.sortedWith(compareBy({ it[0] }, { it[1] }))
                return sortedPairs
            }
        }
    }
}