package com.android.nova.leetcode.blind75Test.graphs

import java.util.LinkedList

/**
 *
 */
class No1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun cloneGraph(node: Node?): Node? {
            if (node == null) {
                return null
            }

            val nodesMemo = HashMap<Node, Node>()
            val queue = LinkedList<Node>()
            queue.add(node)

            while (!queue.isEmpty()) {
                val currentNode = queue.poll()
                if (!nodesMemo.contains(currentNode)) {
                    nodesMemo[currentNode] = Node(currentNode.`val`)

                    for (neigbor in currentNode.neighbors) {
                        //nodesMemo[neigbor] = Node(neigbor.`val`)
                        //queue.add(neigbor)
                    }
                }
            }

            for ((originalNode, clonedNode) in nodesMemo) {
                for (originalitemNode in originalNode.neighbors){
                    val clonedItemNode = nodesMemo.getOrDefault(originalitemNode,null)
                    clonedNode.neighbors.add(clonedItemNode)
                }
            }

            return nodesMemo.getOrDefault(node,null)
        }
    }
    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList<Node?>()
    }
}