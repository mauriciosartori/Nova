package com.android.nova.leetcode.blind75Test.dp
/**
 *
 */
class No5 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
            val result = ArrayList<List<Int>>()
            dfs(0, ArrayList(), 0, target, result, candidates)
            return result
        }

        fun dfs(i:Int, currentArray:ArrayList<Int>, totalSum: Int, target: Int, result:ArrayList<List<Int>>,candidates: IntArray) {
            if (totalSum == target) {
                result.add(ArrayList(currentArray))
                return
            }

            if (i >= candidates.size || totalSum > target) {
                return
            }
            currentArray.add(candidates[i])
            dfs(i, currentArray, totalSum + candidates[i], target, result, candidates)
            currentArray.removeAt(currentArray.size - 1)
            dfs(i + 1, currentArray, totalSum, target, result, candidates)

        }
    }
}