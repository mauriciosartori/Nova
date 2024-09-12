package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No15 {
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

            val R = 1
            val C = 9
            val G = arrayOf(
                arrayOf("x", "S", ".", ".", "x", ".", ".", "E", "x")
            )

            // Now you can call the function with these inputs
            val result = No15.getSecondsRequired(R, C, G)
            println("Result: $result")
        }
        // Write any import statements here

        fun getSecondsRequired(R: Int, C: Int, G: Array<Array<String>>): Int {
            val matrix = G
            val rows = R
            val cols = C
            var start = Pair(0,0)
            val mapPortals = HashMap<String, MutableList<Pair<Int, Int>>>()
            val memo = Array(rows){IntArray(cols)}

            for (row in 0 until rows) {
                for (col in 0 until cols) {
                    val currentValue = matrix[row][col]
                    if (currentValue.equals("S")) {
                        start = Pair(row, col)
                    }
                    if (!currentValue.equals(".") && !currentValue.equals("#")) {
                        mapPortals.getOrPut(currentValue) { mutableListOf() }.add(Pair(row, col))
                    }
                }
            }

            var minSteps = Integer.MAX_VALUE

            fun findShortestExit(row: Int, col: Int, steps: Int) {
                if (row == 0 && col == 0) {
                    println("andas!")
                }

                if (row < 0 || col < 0 || row >= rows || col >= cols) {
                    return
                }
                if (matrix[row][col].equals("#")) {
                    return
                }
                if (matrix[row][col].equals("E")) {
                    minSteps = minOf(minSteps, steps)
                    return
                }

                if (memo[row][col] == 2 || memo[row][col] == 1) {
                    return
                }

                memo[row][col] = 1
                val nextMovesArray = arrayOf(Pair(-1, 0), Pair(0, 1), Pair(1, 0), Pair(0, -1))
                for (nxtMove in nextMovesArray) {
                    findShortestExit(row + nxtMove.first, col + nxtMove.second, steps + 1)
                }

                val portals = mapPortals.getOrDefault(matrix[row][col], mutableListOf())
                var newSteps = steps
                if (matrix[row][col].equals("S")) {
                    newSteps = 0
                }
                if (portals.size != 0) {
                    for (portal in portals) {
                        findShortestExit(portal.first, portal.second, newSteps + 1)
                    }
                }


                memo[row][col] = 2
            }

            findShortestExit(start.first, start.second, 0)
            return minSteps
        }
    }
}