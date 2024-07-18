package com.android.nova.inverviewcamp.graphs

import java.util.Stack

/**
 *
 */
class GraphsDFS {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Example using DFS")
            val myGraph = LocalGraph()
            printGraph(myGraph)
        }

        fun printGraph(myGraph: LocalGraph) {
            val myStack = Stack<LocalGraphNode>()
            val startNode = myGraph.listNodes.first()
            startNode.status = LocalGraphStatus.STANDBY
            myStack.push(startNode)
            while (!myStack.isEmpty()) {
                val currentNode = myStack.pop()
                for (itemNode in currentNode.listConnectedNodes) {
                    if (itemNode.status == LocalGraphStatus.AVAILABLE) {
                        itemNode.status = LocalGraphStatus.STANDBY
                        myStack.push(itemNode)
                    }
                }
                currentNode.status = LocalGraphStatus.DONE
                print("${currentNode.value}- > ")
            }
        }
    }
}