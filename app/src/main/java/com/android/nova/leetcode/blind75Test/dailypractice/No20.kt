package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No20 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val N = 4
            val L = arrayOf(4, 1, 2, 1)  // Adjusted to 0-based indexing

            // Create an instance of No20 and call the function
            val result = getMaxVisitableWebpages(N, L)
            println("Max visitable webpages: $result")
        }
        // Write any import statements here

        fun getMaxVisitableWebpages(N: Int, L: Array<Int>): Int {
            val chaptersList = L

            fun dfs(chapterIndex: Int, counter:Int, setVisited: HashSet<Int>): Int {
                if (setVisited.contains(chapterIndex)) {
                    return counter
                }
                val nextChapterIndex = (chaptersList[chapterIndex] - 1)
                setVisited.add(chapterIndex)

                return dfs(nextChapterIndex, counter + 1, setVisited)
            }

            var count = 0
            for (nextIndex in chaptersList) {
                val steps = dfs(nextIndex, 1, HashSet<Int>())
                count = maxOf(count, steps)
            }

            return count
        }
    }
}