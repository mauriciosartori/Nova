package com.android.nova.leetcode.blind75Test.matrix
/**
 *
 */
class No4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val board: Array<CharArray> = arrayOf(
//                charArrayOf('A', 'B', 'C', 'E'),
//                charArrayOf('S', 'F', 'C', 'S'),
//                charArrayOf('A', 'D', 'E', 'E')
//            )
//            val word = "ABCB"
//            val board: Array<CharArray> = arrayOf(
//                charArrayOf('A', 'B', 'C', 'E'),
//                charArrayOf('S', 'F', 'C', 'S'),
//                charArrayOf('A', 'D', 'E', 'E')
//            )
//            val word = "ABCCED"

            val board: Array<CharArray> = arrayOf(
                charArrayOf('a', 'a')
            )
            val word = "aa"
            val result = exist(board, word)
            println("Word '$word' exists in the board: $result")
        }
        fun exist(board: Array<CharArray>, word: String): Boolean {
            val setMemo = HashSet<Pair<Int, Int>>()
            if (board.size == 1 && board[0].size == 1) {
                return board[0][0] == word[0] && word.length == 1
            }

            for (row in 0 until board.size) {
                for (col in 0 until board[0].size) {
                    if (board[row][col] == word[0]) {
                        val result = backTrack(board, row, col, setMemo, word, 0, board.size, board[0].size)
                        if (result) {
                            return true
                        }
                    }
                }
            }
            return false
        }

        fun backTrack(board: Array<CharArray>, row: Int, col: Int, setMemo: HashSet<Pair<Int, Int>>, word: String, index: Int, n: Int, m: Int): Boolean {

            if (row > n - 1 || col > m -1 || row < 0 || col < 0) {
                return false
            }

            if (index == word.length) {
                return true
            }

            if (board[row][col] != word[index]) {
                return false
            }

            if (setMemo.contains(Pair(row, col))) {
                return false
            }
            val positions = arrayOf(intArrayOf(-1,0),
                intArrayOf(0,1),
                intArrayOf(1,0),
                intArrayOf(0,-1)
            )
            setMemo.add(Pair(row, col))
            for (position in positions) {
                val result = backTrack(board, row + position[0], col + position[1], setMemo, word, index + 1, n, m)
                if (result) {
                    return true
                }
            }
            setMemo.remove(Pair(row, col))
            return false
        }
    }
}