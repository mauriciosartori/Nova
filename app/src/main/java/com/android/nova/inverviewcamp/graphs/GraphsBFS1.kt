package com.android.nova.inverviewcamp.graphs

import java.util.LinkedList
import java.util.Queue

/**
 * Print Graph in Level Order:
 * Given a graph and a node N, print the Graph in order of distance from N.
 * All nodes of distance 1 from N, followed by nodes of distance 2 from N, etc.
 */
class GraphsBFS1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Printing a Graph with in different levels")
            printGraphLevels()
        }

        fun printGraphLevels() {
            val myGraph = InPlaceGraph()

            val myQueue = LinkedList<LocalGraphNode>()
            myQueue.add(myGraph.listNodes[0])

            while (!myQueue.isEmpty()) {
                val currentNode = myQueue.pop()
                print("${currentNode.value} - ")
                if (myQueue.isEmpty()) {
                    println("----------")
                }
                for (itemNode in currentNode.listConnectedNodes) {
                    myQueue.add(itemNode)
                }
            }
        }
    }

    private class InPlaceGraph {
        var listNodes = ArrayList<LocalGraphNode>()

        init {
            val nodeA = LocalGraphNode("A")
            val nodeB = LocalGraphNode("B")
            val nodeC = LocalGraphNode("C")
            val nodeD = LocalGraphNode("D")
            val nodeE = LocalGraphNode("E")
            val nodeF = LocalGraphNode("F")

            nodeA.listConnectedNodes.add(nodeB)
            nodeA.listConnectedNodes.add(nodeC)

            nodeB.listConnectedNodes.add(nodeD)
            nodeB.listConnectedNodes.add(nodeE)

            nodeC.listConnectedNodes.add(nodeF)

            nodeD.listConnectedNodes.add(nodeE)

           // nodeE.listConnectedNodes.add(nodeC)

            listNodes.add(nodeA)

        }
    }
}