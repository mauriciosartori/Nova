package com.android.nova.leetcode.blind75Test.graphs
/**
 *
 */
class No2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun cloneGraph(node: Node?): Node? {
            val memoOldNewNodes = HashMap<Node, Node>()

            return dfs(node, memoOldNewNodes)
        }

        fun dfs(node:Node?, memoOldNew:HashMap<Node, Node> ): Node? {
            if (node == null) {
                return null
            }
            if (memoOldNew.contains(node)){
                return memoOldNew[node]
            }
            val copy = Node(node.`val`)
            memoOldNew[node] = copy
            for (neig in node.neighbors) {
                copy.neighbors.add(dfs(neig, memoOldNew))
            }
            return copy
        }
    }
    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList<Node?>()
    }
}