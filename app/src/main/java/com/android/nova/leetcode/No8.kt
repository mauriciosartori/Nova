package com.android.nova.leetcode

import java.util.LinkedList

/**
 *
 */
class No8 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val grid: Array<CharArray> = arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1')
            )
            val result = numIslands(grid)
            println("The result is $result")

        }
        fun numIslands(grid: Array<CharArray>): Int {
            val rows = grid.size
            val cols = grid[0].size
            val memo = Array(rows){BooleanArray(cols)}

            val queue = LinkedList<Pair<Int, Int>>()

            var result = 0
            for (i in 0..<grid.size) {
                for (j in 0..<grid[0].size) {
                    if (!memo[i][j] && grid[i][j] == '1') {

                        if (bfs(i, j, rows, cols, memo, queue, grid) > 0) {
                            result++
                        }
                    }
                }
            }

            return result
        }

        fun bfs(row:Int, col: Int, rows:Int, cols:Int, memo:Array<BooleanArray>, queue: LinkedList<Pair<Int, Int>>, grid: Array<CharArray>): Int {
            queue.add(Pair(row,col))
            val adjacentCoordinates = arrayOf(Pair(-1, 0), Pair(0, 1), Pair(1, 0), Pair(0, -1))
            var count = 0

            while (!queue.isEmpty()) {
                val item = queue.remove()
                val itemRow = item.first
                val itemCol = item.second
                if (memo[itemRow][itemCol] == true) {
                    continue
                }
                if (grid[itemRow][itemCol] == '1') {
                    count++
                }
                memo[itemRow][itemCol] = true
                for (nextIndexes in adjacentCoordinates) {
                    val nextRow = itemRow + nextIndexes.first
                    val nextCol = itemCol + nextIndexes.second
                    if (nextRow >= 0 && nextCol >= 0 && nextRow < rows && nextCol < cols) {
                        if (memo[nextRow][nextCol] == false) {
                            if (grid[nextRow][nextCol] == '1') {
                                queue.add(Pair(nextRow, nextCol))
                            }
                        }
                    }
                }
            }
            return count
        }
    }
}