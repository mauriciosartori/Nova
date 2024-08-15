package com.android.nova.inverviewcamp.graphsDos
/**
 *
 */
class FindIslands {
    companion object {

        val canvasArray = arrayOf(
            arrayOf(1,0,1,0,1),
            arrayOf(1,1,0,0,0),
            arrayOf(0,1,0,1,1),
        )
        @JvmStatic
        fun main(args: Array<String>) {
            println("Find the islands in the following array of 0's and 1's")
            findIslandsAround(canvasArray)
        }

        fun findIslandsAround(canvasArray:Array<Array<Int>>) {
            val visitedArray = Array(canvasArray.size){BooleanArray(canvasArray[0].size)}
            var numIslands = 0
            for (row in canvasArray.indices) {
                for (col in canvasArray[0].indices) {
                    if (applyBFS(canvasArray, visitedArray, row, col)) {
                        numIslands++
                    }
                }
            }
            println("The number of islands is $numIslands")
        }

        fun applyBFS(canvasArray: Array<Array<Int>>, visitedArray: Array<BooleanArray>, row: Int, col: Int): Boolean {
            return findUsingBFS(canvasArray, visitedArray, row, col)
        }

        fun findUsingBFS(canvasArray: Array<Array<Int>>, visitedArray: Array<BooleanArray>, row:Int, col:Int): Boolean {
            if (canvasArray[row][col] == 1 && visitedArray[row][col] == false) {
                visitedArray[row][col] = true
                for (coordinateIndex in 1..8) {
                    val itemCoordinate = getCoordinate(coordinateIndex, row, col)
                    val isValid = isValidCoordinate(itemCoordinate, canvasArray.size, canvasArray[0].size)
                    if (isValid) {
                        val temp = findUsingBFS(canvasArray, visitedArray, itemCoordinate.first, itemCoordinate.second)
                       // return temp
                    }
                }
                return true
            }
            return false
        }

        fun isValidCoordinate(coordinate: Pair<Int, Int>, rowsSize: Int, colsSize: Int):Boolean{
            return coordinate.first < rowsSize && coordinate.second < colsSize && coordinate.first >= 0 && coordinate.second >= 0
        }

        fun getCoordinate(coordinateNumber:Int, row: Int, col:Int): Pair<Int, Int> {
            return when {
                coordinateNumber == 1 -> return Pair(row - 1, col - 1)
                coordinateNumber == 2 -> return Pair(row - 1, col)
                coordinateNumber == 3 -> return Pair(row - 1 , col + 1)
                coordinateNumber == 4 -> return Pair(row , col - 1)
                coordinateNumber == 5 -> return Pair(row , col + 1)
                coordinateNumber == 6 -> return Pair(row + 1, col - 1 )
                coordinateNumber == 7 -> return Pair(row + 1, col )
                coordinateNumber == 8 -> return Pair(row + 1, col + 1)

                else -> return Pair(row, col)

            }
        }
    }
}