package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No20 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // First input
            var N = 4
            var L = arrayOf(4, 1, 2, 1)

            // Call the function with the first set of inputs
             var result = getMaxVisitableWebpages(N, L)
            println("Max visitable webpages for  EXPECTED 4 : $result")

            // Second input
            N = 5
            L = arrayOf(4, 3, 5, 1, 2)

            // Call the function with the second set of inputs
            var resultado = getMaxVisitableWebpages(N, L)
            println("Max visitable webpages for EXPECTED 3 : $resultado")
        }
        // Write any import statements here

        fun getMaxVisitableWebpages(N: Int, L: Array<Int>): Int {
            val chaptersList = L
            val memoMap = HashMap<Pair<Int, Int>, Int>()
            var lastValueAdded = 0

            fun dfs(chapterIndex: Int, counter:Int, setVisited: HashSet<Int>): Int {
                if (setVisited.contains(chapterIndex)) {
                    return counter
                }
                val nextChapterIndex = (chaptersList[chapterIndex] - 1)
                val memoPair = Pair(chapterIndex, nextChapterIndex)
                if (memoMap.contains(memoPair) && !setVisited.contains(nextChapterIndex)) {
                    return memoMap.getOrDefault(memoPair, 1) + counter
                }
                setVisited.add(chapterIndex)
                lastValueAdded = chapterIndex
                val result = dfs(nextChapterIndex, counter + 1, setVisited)

                return result
            }

            var count = 0
            for (index in chaptersList.indices) {
                val steps = dfs(index, 0, HashSet<Int>())
                val memoPair = Pair(index, lastValueAdded)
                memoMap[memoPair] = steps
                count = maxOf(count, steps)
            }

            return count
        }
    }
}