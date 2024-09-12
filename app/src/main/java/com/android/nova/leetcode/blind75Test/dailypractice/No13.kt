package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No13 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val N = 5
            val C = "APABA"
            val X = 1
            val Y = 2
            val result = getArtisticPhotographCount(N, C, X, Y)
            println("Result: $result")
        }

        // Write any import statements here

        fun getArtisticPhotographCount(N: Int, C: String, X: Int, Y: Int): Long {
            val listA = ArrayList<Int>()
            val listB = ArrayList<Int>()
            val listP = ArrayList<Int>()
            val inputArrray = C
            var count = 0

            for (i in 0 until N) {
                if (inputArrray[i] == 'P') {
                    for (aListIndex in 0 until listA.size) {
                        val aIndex = listA.get(aListIndex)
                        val aDistance = i - aIndex
                        if (aDistance >= X && aDistance <= Y){
                            for (bListIndex in 0 until listB.size) {
                                val bIndex = listB.get(bListIndex)
                                val bDistance = aIndex - bIndex
                                if (bDistance >= X && bDistance <= Y){
                                    count++
                                } else if (bDistance > Y) {
                                    //listB.remove(bListIndex)
                                }
                            }
                        } else if (aDistance > Y) {
                            //listA.remove(aListIndex)
                        }
                    }
                }
                if (inputArrray[i] == 'B') {
                    for (aListIndex in 0 until listA.size) {
                        val aIndex = listA.get(aListIndex)
                        val aDistance = i - aIndex
                        if (aDistance >= X && aDistance <= Y){
                            for (pListIndex in 0 until listP.size) {
                                val pIndex = listP.get(pListIndex)
                                val pDistance = aIndex - pIndex
                                if (pDistance >= X && pDistance <= Y){
                                    count++
                                } else if (pDistance > Y) {
                                    //listP.remove(pListIndex)
                                }
                            }
                        } else if (aDistance > Y) {
                            //listA.remove(aListIndex)
                        }
                    }
                }
                if (inputArrray[i] == 'A') {
                    listA.add(i)
                }
                if (inputArrray[i] == 'B') {
                    listB.add(i)
                }
                if (inputArrray[i] == 'P') {
                    listP.add(i)
                }
            }

            return count.toLong()
        }
    }
}