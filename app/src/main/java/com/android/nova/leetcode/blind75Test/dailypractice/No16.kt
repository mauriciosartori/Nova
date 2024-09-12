package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No16 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val R = 3
//            val C = 3
//            val G = arrayOf(
//                arrayOf(".", "E", "."),
//                arrayOf(".", "#", "E"),
//                arrayOf(".", "S", "#")
//            )
            //////////////
//            val R = 3
//            val C = 4
//            val G = arrayOf(
//                arrayOf("a", ".", "S", "a"),
//                arrayOf("#", "#", "#", "#"),
//                arrayOf("E", "b", ".", "b")
//            )

            /////////////
            val R = 1
            val C = 9
            val G = arrayOf(
                arrayOf("x", "S", ".", ".", "x", ".", ".", "E", "x")
            )

            // Now you can call the function with these inputs
            val result = getSecondsRequired(R, C, G)
            println("Result: $result")
        }

        // Write any import statements here

        fun getSecondsRequired(R: Int, C: Int, G: Array<Array<String>>): Int {
            val rowsTotal = R
            val colsTotal = C
            val matrix = G
            var start = Pair(0,0)
            val memo = Array(rowsTotal) {IntArray(colsTotal)}
            var portalMap = HashMap<String, MutableList<Pair<Int, Int>>>()

            for (row in 0 until rowsTotal) {
                for (col in 0 until colsTotal) {
                    val currentCell = matrix[row][col]
                    if (currentCell.equals("S")) {
                        start = Pair(row, col)
                    }
                    if (!currentCell.equals("S") && !currentCell.equals("#") && !currentCell.equals("E") && !currentCell.equals(".")) {
                        portalMap.getOrPut(currentCell) { ArrayList() }.add(Pair(row, col))
                    }
                }
            }
            var steps = 0
            var exitFound = false
            var queue = ArrayDeque<Pair<Int, Int>>()
            queue.add(start)
            memo[start.first][start.second] = 1
            queue.add(Pair(1919, 1919))

            while (!queue.isEmpty()) {
                val cell = queue.removeFirst()
                val row = cell.first
                val col = cell.second

                if (row == 1919 && col == 1919 && !queue.isEmpty()) {
                    queue.add(Pair(1919, 1919))
                    steps++
                    continue
                }
                if (row == 1919 && col == 1919 && queue.isEmpty()) {
                    break
                }
                val currentValue = matrix[row][col]
                if (currentValue.equals("#")) {
                    continue
                }
                if (currentValue.equals("E")) {
                    exitFound = true
                    break
                }

                val nextPositions = arrayOf(Pair(-1, 0), Pair(0, 1), Pair(1, 0), Pair(0, -1))

                for (portalPosition in portalMap.getOrDefault(currentValue, ArrayList())) {
                    if (portalPosition != Pair(row, col) && memo[portalPosition.first][portalPosition.second] == 0) {
                        queue.add(portalPosition)
                        memo[portalPosition.first][portalPosition.second] = 1
                    }
                }
                for (newPosition in nextPositions) {
                    val nextRow = row + newPosition.first
                    val nextCol = col + newPosition.second
                    if (nextRow >= 0 && nextCol >= 0 && nextRow < rowsTotal && nextCol < colsTotal) {
                        if (memo[nextRow][nextCol] == 0) {
                            queue.add(Pair(nextRow, nextCol))
                            memo[nextRow][nextCol] = 1
                        }
                    }
                }
                memo[row][col] = 2
            }

            return if (exitFound) steps else -1
        }
    }
}