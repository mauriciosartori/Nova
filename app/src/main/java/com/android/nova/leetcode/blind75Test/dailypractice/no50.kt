package com.android.nova.leetcode.blind75Test.dailypractice

import java.util.LinkedList

/**
 *
 */
class no50 {
    class TreeNode(var `val`: Int) {
             var left: TreeNode? = null
             var right: TreeNode? = null
         }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun findLeaves(root: TreeNode?): List<List<Int>> {

            fun removeLeaves(startNode: TreeNode?): List<Int> {
                val queue = LinkedList<Pair<TreeNode?, TreeNode?>>()
                queue.add(Pair(startNode, null))

                var leavesList = mutableListOf<Int>()
                while (queue.isNotEmpty()) {
                    val (node, parent) = queue.poll()
                    if (node == null) {
                        continue
                    }
                    if (node?.left == null && node?.right == null) {
                        val nodeValue = node?.`val` ?: 0
                        leavesList.add(nodeValue)
                        if (parent?.left != null && parent?.left?.`val` == nodeValue) {
                            parent?.left = null
                        }
                        if (parent?.right != null && parent?.right?.`val` == nodeValue) {
                            parent?.right = null
                        }

                        continue
                    }
                    queue.add(Pair(node?.left, node))
                    queue.add(Pair(node?.right, node))
                }
                return leavesList
            }
            val result = mutableListOf<List<Int>>()
            val rootValue = root?.`val`
            var expected = -1

            while (expected != rootValue) {
                val listLeaves = removeLeaves(root)
                println(listLeaves.joinToString())
                result.add(listLeaves)
                expected = listLeaves[0]
            }

            return result
        }
    }
}