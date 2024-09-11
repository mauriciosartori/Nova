package com.android.nova.leetcode.blind75Test.dailypractice

import java.util.ArrayList

/**
 *
 */
class No8 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }

        fun getArtisticPhotographCount(N: Int, C: String, X: Int, Y: Int): Int {
            val photoArray = C
            var result = 0
            for (index in 0 until N) {
                if (photoArray[index] == 'P' || photoArray[index] == 'B') {
                    var lastChar = ' '
                    if (photoArray[index] == 'P') {
                        lastChar = 'B'
                    } else {
                        lastChar = 'P'
                    }
                    var aFoundList = ArrayList<Int>()

                    for (aIndex in index + X .. index + Y) {
                        if (aIndex >= N) {
                            break
                        }
                        if (photoArray[aIndex] == 'A') {
                            aFoundList.add(aIndex)
                        }
                    }

                    if (aFoundList.size == 0) {
                        continue
                    }

                    for (lastIndex in aFoundList) {
                        for (lIndex in lastIndex + X .. lastIndex + Y) {
                            if (lIndex >= N) {
                                break
                            }
                            if (photoArray[lIndex] == lastChar) {
                                result++
                            }
                        }
                    }

                }

            }

            return result
        }
    }
}