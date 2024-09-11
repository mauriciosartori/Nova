package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(2,3,6,7)
            val result = combinationSum(inputArray, 7)
            println("The result for No4 is ${result.toString()}")
        }
        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
            val result = ArrayList<List<Int>>()
            findCandidates(0,ArrayList<Int>(), 0, target, result, candidates)
            return result
        }


        fun findCandidates(index: Int, currentArray: ArrayList<Int>, currentSum: Int, target:Int, result: ArrayList<List<Int>>, candidates: IntArray){
            if (currentSum == target) {
                result.add(ArrayList(currentArray))
                return
            }

            if (index >= candidates.size ) {
                return
            }

            if (currentSum > target) {
                return
            }

            findCandidates(index + 1, currentArray, currentSum, target, result, candidates)

            currentArray.add(candidates[index])
            findCandidates(index, currentArray, currentSum + candidates[index], target, result, candidates)
            currentArray.removeLast()

            return
        }
    }
}