package com.android.nova.leetcode.blind75Test.matrix
/**
 *
 */
class No3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val matrix: Array<IntArray> = arrayOf(
                intArrayOf(5, 1, 9, 11),
                intArrayOf(2, 4, 8, 10),
                intArrayOf(13, 3, 6, 7),
                intArrayOf(15, 14, 12, 16)
            )
            rotate(matrix)
            println("The result for No3 is:")

            // Print the matrix
            for (row in matrix) {
                println(row.joinToString(" "))
            }
        }
        fun rotate(matrix: Array<IntArray>): Unit {
            for (row in 0 until matrix.size) {
                for (col in 0 until matrix[0].size) {
                    if (row != col && row > col) {
                        transpose(matrix, row, col)
                    }
                }
            }
            var left = 0
            var right = matrix.size - 1

            while (left < right) {
                swapCols(matrix, left, right)
                left++
                right--
            }
        }

        fun transpose(matrix: Array<IntArray>, row:Int, col:Int) {
            val temp = matrix[row][col]
            matrix[row][col] = matrix[col][row]
            matrix[col][row] = temp
        }

        fun swapCols(matrix: Array<IntArray>, left: Int, right: Int) {
            for (row in 0 until matrix.size) {

                val temp = matrix[row][left]
                matrix[row][left] = matrix[row][right]
                matrix[row][right] = temp
            }
        }
    }
}