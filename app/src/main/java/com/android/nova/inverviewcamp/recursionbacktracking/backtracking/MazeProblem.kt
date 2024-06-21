package com.android.nova.inverviewcamp.recursionbacktracking.backtracking
/**
 *
 */
class MazeProblem {
    companion object {
        val mazeBoard: Array<Array<Int>> = arrayOf(
            arrayOf(0, 1, 1, 1),
            arrayOf(0, 0, 0, 1),
            arrayOf(1, 0, 0, 1),
            arrayOf(1, 1, 0, 0),
        )

        val mazMemo: Array<Array<CellState>> = arrayOf(
            arrayOf(CellState.UNVISITED, CellState.UNVISITED, CellState.UNVISITED, CellState.UNVISITED),
            arrayOf(CellState.UNVISITED, CellState.UNVISITED, CellState.UNVISITED, CellState.UNVISITED),
            arrayOf(CellState.UNVISITED, CellState.UNVISITED, CellState.UNVISITED, CellState.UNVISITED),
            arrayOf(CellState.UNVISITED, CellState.UNVISITED, CellState.UNVISITED, CellState.UNVISITED),
        )
        @JvmStatic
        fun main(args: Array<String>) {
            println("Initial matrix")
            printMatrix(mazeBoard)
            val result = pathExist(mazeBoard, 0, 0, mazMemo)
            println("The result is $result")
        }

        fun oob(i:Int, j:Int): Boolean {
             if  (i > 3 || i < 0 || j > 3 || j < 0 ) {
                 return true
             }
            return false
        }
        fun pathExist(mazeBoard: Array<Array<Int>>, i:Int, j:Int, mazMemo: Array<Array<CellState>>):Boolean {
            if (oob(i,j) || mazeBoard[i][j] == 1) {
                return false
            }
            if (i == mazeBoard.size - 1 && j == mazeBoard[0].size - 1) {
                return true
            }
            if (mazMemo[i][j] == CellState.VISITING || mazMemo[i][j] == CellState.PATH_NOT_FOUND) {
                return false
            }
            mazMemo[i][j] = CellState.VISITING

            val pairs: Array<Pair<Int, Int>> = arrayOf(
                Pair(i + 1, j),
                Pair(i, j + 1),
                Pair(i - 1, j),
                Pair(i, j - 1),
            )


            for (pair in pairs) {
                if (pathExist(mazeBoard, pair.first, pair.second, mazMemo)) {
                    return true
                }
            }
            mazMemo[i][j] = CellState.PATH_NOT_FOUND

            return false
        }

        fun printMatrix(matrix: Array<Array<Int>>) {
            for (row in matrix) {
                for (element in row) {
                    print("$element ")
                }
                println()
            }
        }
    }
}

enum class CellState {
    UNVISITED, VISITING, PATH_NOT_FOUND, PATH_FOUND
}