package com.android.nova.leetcode.blind75Test.matrix
/**
 *
 */
class No1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val matrix: Array<IntArray> = arrayOf(
                intArrayOf(0, 1, 2, 0),
                intArrayOf(3, 4, 5, 2),
                intArrayOf(1, 3, 1, 5)
            )
            setZeroes(matrix)
            println("The result for No1 is ")
            for (row in matrix) {
                println(row.joinToString(" "))
            }
        }

        fun setZeroes(matrix: Array<IntArray>): Unit {
            val matrixStates: Array<IntArray> = Array(matrix.size){IntArray(matrix[0].size)}
            // 0 -> unused
            // 1 -> found
            // 2 -> modified
            for (row in 0 until matrix.size) {
                for (col in 0 until matrix[0].size) {
                    if (matrix[row][col] == 0 && matrixStates[row][col] != 1) {
                        for (rowFilled in 0 until matrix.size) {
                            if (rowFilled != row && matrix[rowFilled][col] != 0) {
                                matrix[rowFilled][col] = 0
                                matrixStates[rowFilled][col] = 1
                            }
                        }
                        for (colFilled in 0 until matrix[0].size) {
                            if (colFilled != col && matrix[row][colFilled] != 0) {
                                matrix[row][colFilled] = 0
                                matrixStates[row][colFilled] = 1
                            }
                        }
                        matrixStates[row][col] = 2
                    }
                }
            }
        }
    }
}