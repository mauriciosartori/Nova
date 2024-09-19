package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No28 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val grid = arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0')
            )

            val result = numIslands(grid)
            println("Number of Islands: $result")
        }
        fun numIslands(grid: Array<CharArray>): Int {
            val memo = Array(grid.size){IntArray(grid[0].size)}

            fun bfs(row:Int, col:Int) {
                val queue = ArrayDeque<Pair<Int,Int>>()
                queue.add(Pair(row, col))

                while (!queue.isEmpty()) {
                    val pair = queue.removeFirst()
                    if (grid[pair.first][pair.second] == '0') {
                        continue
                    }
                    if (memo[pair.first][pair.second] != 0) {
                        continue
                    }
                    memo[pair.first][pair.second] = 1
                    val nextMoves = arrayOf(Pair(-1,0), Pair(0,1), Pair(1,0), Pair(0,-1))
                    for (nextMove in nextMoves) {
                        val nextRow = pair.first + nextMove.first
                        val nextCol = pair.second + nextMove.second
                        if (nextRow >= 0 && nextCol >= 0 && nextRow < grid.size && nextCol < grid[0].size) {
                            if (grid[nextRow][nextCol] == '1') {
                                queue.add(Pair(nextRow, nextCol))
                            }
                        }
                    }
                }
            }
            var numIslands = 0
            for (row in grid.indices) {
                for (col in grid[0].indices) {
                    if (grid[row][col] == '1' && memo[row][col] == 0) {
                        bfs(row, col)
                        numIslands++
                    }
                }
            }

            return numIslands
        }
    }
}