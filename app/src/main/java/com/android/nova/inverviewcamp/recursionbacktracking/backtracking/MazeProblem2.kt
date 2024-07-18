package com.android.nova.inverviewcamp.recursionbacktracking.backtracking
/**
 *
 */
class MazeProblem2 {
    companion object {
        val mazeBoard: Array<Array<Int>> = arrayOf(
            arrayOf(0, 1, 1, 1),
            arrayOf(0, 0, 0, 1),
            arrayOf(1, 0, 0, 0),
            arrayOf(1, 1, 1, 0),
        )


        val mazMemo: Array<Array<CellState2>> = arrayOf(
            arrayOf(
                CellState2.UNVISITED,
                CellState2.UNVISITED,
                CellState2.UNVISITED,
                CellState2.UNVISITED
            ),
            arrayOf(
                CellState2.UNVISITED,
                CellState2.UNVISITED,
                CellState2.UNVISITED,
                CellState2.UNVISITED
            ),
            arrayOf(
                CellState2.UNVISITED,
                CellState2.UNVISITED,
                CellState2.UNVISITED,
                CellState2.UNVISITED
            ),
            arrayOf(
                CellState2.UNVISITED,
                CellState2.UNVISITED,
                CellState2.UNVISITED,
                CellState2.UNVISITED
            ),
        )

        @JvmStatic
        fun main(args: Array<String>) {
            println("Initial matrix")
            printMatrix(mazeBoard)
            val result = pathExist(mazeBoard, mazMemo, 0, 0)
            println("The result is $result")
        }

        fun pathExist(mazeBoard: Array<Array<Int>>, mazMemo: Array<Array<CellState2>>, row: Int, col: Int): Boolean {
            // Base cases
            if (!isValidIndex(mazeBoard.size, row, col) || isAWall(mazeBoard, row, col)) {
                return false
            }

            if (row == mazeBoard.size - 1 && col == mazeBoard.size - 1) {
                println("En algun momento entro aqui")
                return true
            }

            if (mazMemo[row][col] == CellState2.VISITED || mazMemo[row][col] == CellState2.VISITING) {
                return false
            }

            mazMemo[row][col] = CellState2.VISITING
            val movesArray: Array<Pair<Int, Int>> =
                arrayOf(
                    Pair(row - 1, col),
                    Pair(row, col + 1),
                    Pair(row + 1, col),
                    Pair(row, col - 1)
                )


            for (pair in movesArray) {
                if (pathExist(mazeBoard, mazMemo, pair.first, pair.second)) {
                    println("Path was found!! Awiwi! ??")
                    return true
                }
            }
            mazMemo[row][col] = CellState2.VISITED
            return false
        }

        fun isAWall(mazeBoard: Array<Array<Int>>,row: Int, col: Int):Boolean {
            return mazeBoard[row][col] == 1
        }

        fun isValidIndex(size: Int, row: Int, col: Int):Boolean {
            return row >=0 && row < size && col >= 0 && col < size
        }

        fun printMatrix(mazeBoard: Array<Array<Int>>) {
            for (i in mazeBoard.indices) {
                for (j in mazeBoard.indices) {
                    print("${mazeBoard[i][j]}, ")
                }
                println(" ")
            }
        }
        enum class CellState2 { UNVISITED, VISITING, VISITED }
    }
}


