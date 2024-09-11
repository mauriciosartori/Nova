package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(2,3,6,7)
            val result = combinationSum(inputArray, 7)
            println("The result for No3 is ${result.toString()}")
        }
        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
            val result = ArrayList<List<Int>>()
            for (candidate in candidates) {
                val resultItem = findCandidates(candidate, 0, candidates, ArrayList<Int>(), target)
                if (resultItem != null) {
                    result.add(resultItem)
                }
            }

            return result
        }

        fun findCandidates(candidateValue: Int, currentSum: Int , candidates: IntArray, currentSolutions: ArrayList<Int> , target:Int): List<Int>? {
            if (currentSum >  target) {
                return null
            }

            if (currentSum ==  target) {
                return currentSolutions
            }

            currentSolutions.add(candidateValue)
            for (candidate in candidates) {
                val currentSumParam = candidate + candidateValue
                val result = findCandidates(candidate, currentSumParam, candidates, currentSolutions, target)
                if (result != null) {
                    return result
                }
            }
            currentSolutions.remove(candidateValue)

            return null
        }
    }
}