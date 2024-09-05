package com.android.nova.leetcode.blind75Test.matrix
/**
 *
 */
class No2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val matrix: Array<IntArray> = arrayOf(
//                intArrayOf(0, 1, 2, 0),
//                intArrayOf(3, 4, 5, 2),
//                intArrayOf(1, 3, 1, 5)
//            )
            val matrix: Array<IntArray> = arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 0, 1),
                intArrayOf(1, 1, 1)
            )
            setZeroes(matrix)
            println("The result for No1 is ")
            for (row in matrix) {
                println(row.joinToString(" "))
            }
        }

        fun setZeroes(matrix: Array<IntArray>): Unit {
            val arrayRows = IntArray(matrix.size)
            val arrayCols = IntArray(matrix[0].size)

            for (row in 0 until matrix.size) {
                for (col in 0 until matrix[0].size) {
                    if (matrix[row][col] == 0) {
                        arrayRows[row] = 1
                        arrayCols[col] = 1
                    }
                }
            }

            for (row in 0 until matrix.size) {
                for (col in 0 until matrix[0].size) {
                    if (arrayRows[row] == 1 || arrayCols[col] == 1) {
                        matrix[row][col] = 0
                    }
                }
            }

        }
    }
}