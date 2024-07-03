package com.android.nova.inverviewcamp.recursionbacktracking.backtracking
/**
 *
 */
class MazeProblem1 {
    companion object {
        val mazeBoard: Array<Array<Int>> = arrayOf(
            arrayOf(0, 1, 1, 1),
            arrayOf(0, 0, 0, 1),
            arrayOf(1, 0, 0, 0),
            arrayOf(1, 1, 1, 0),
        )

        val mazMemo: Array<Array<CellState1>> = arrayOf(
            arrayOf(CellState1.UNVISITED, CellState1.UNVISITED, CellState1.UNVISITED, CellState1.UNVISITED),
            arrayOf(CellState1.UNVISITED, CellState1.UNVISITED, CellState1.UNVISITED, CellState1.UNVISITED),
            arrayOf(CellState1.UNVISITED, CellState1.UNVISITED, CellState1.UNVISITED, CellState1.UNVISITED),
            arrayOf(CellState1.UNVISITED, CellState1.UNVISITED, CellState1.UNVISITED, CellState1.UNVISITED),
        )
        @JvmStatic
        fun main(args: Array<String>) {
            println("Initial matrix")
            printMatrix(mazeBoard)
            val result = pathExist(mazeBoard, mazMemo, 0, 0)
            println("The result is $result")
        }

        fun printMatrix(mazeBoard: Array<Array<Int>>) {
            println("The maze board looks like this ")
            for (i in mazeBoard.indices) {
                for (j in mazeBoard[0].indices) {
                    print("${mazeBoard[i][j]}  ")
                }
                println(" ")
            }
            println(" ")
        }

        fun pathExist(mazeBoard: Array<Array<Int>>, mazMemo: Array<Array<CellState1>>, row: Int, col: Int):Boolean {
            println("##")
            if (!isIndexInsideTheBounds(mazeBoard.size, row, col) || isAWall(mazeBoard, row, col)) {
                return false
            }
            if( row == mazeBoard.size - 1 && col == mazeBoard.size - 1) {
                println("Found it, awiwi!")
                return true
            }
            if (mazMemo[row][col] == CellState1.VISITED || mazMemo[row][col] == CellState1.IN_PROGRESS) {
                return false
            }
            mazMemo[row][col] = CellState1.IN_PROGRESS
            val nextCellsArray:MutableList<Pair<Int, Int>> = mutableListOf()
            nextCellsArray.add(Pair(row, col + 1))
            nextCellsArray.add(Pair(row + 1, col))
            nextCellsArray.add(Pair(row, col - 1))
            nextCellsArray.add(Pair(row - 1, col))

            for ((currentRow, currentCol) in nextCellsArray) {
                if(pathExist(mazeBoard, mazMemo, currentRow, currentCol)) {
                    println(" Iteration done on row $currentRow and col $currentCol")
                    return true
                }
            }
            mazMemo[row][col] = CellState1.VISITED

            return false
        }

        fun isAWall(mazeBoard: Array<Array<Int>>,row: Int, col: Int):Boolean {
            return mazeBoard[row][col] == 1
        }

        fun isIndexInsideTheBounds(maxSize: Int, row: Int, col: Int):Boolean {
            return row < maxSize && col < maxSize && row >= 0 && col >= 0
        }
    }
    enum class CellState1 {
        UNVISITED, IN_PROGRESS, VISITED
    }
}
