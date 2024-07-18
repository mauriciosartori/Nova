package com.android.nova.inverviewcamp.graphs

import java.util.LinkedList
import java.util.Queue

/**
 * Create a graph in a single form
 */
class GraphSingleRepresentation {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Graph structure demo")
            val grapho = Grapho()
            val nodeA = GraphNode("A")
            val nodeB = GraphNode("B")
            val nodeC = GraphNode("C")
            val nodeD = GraphNode("D")
            val nodeE = GraphNode("E")

            nodeA.listConnectedNodes.add(nodeB)

            nodeB.listConnectedNodes.add(nodeA)
            nodeB.listConnectedNodes.add(nodeE)
            nodeB.listConnectedNodes.add(nodeC)

            nodeC.listConnectedNodes.add(nodeB)
            nodeC.listConnectedNodes.add(nodeE)

            nodeD.listConnectedNodes.add(nodeE)

            nodeE.listConnectedNodes.add(nodeD)
            nodeE.listConnectedNodes.add(nodeB)
            nodeE.listConnectedNodes.add(nodeC)


            grapho.listNodes.add(nodeA)
            grapho.listNodes.add(nodeB)
            grapho.listNodes.add(nodeC)
            grapho.listNodes.add(nodeD)
            grapho.listNodes.add(nodeE)

            printNodes(grapho)
        }
        private fun printNodes(grapho: Grapho) {
            println("Printing the following nodes")
            val startNode = grapho.listNodes.first()
            val myQueue = LinkedList<GraphNode>()
            startNode.status = GraphNodeStatus.STANDBY
            myQueue.add(startNode)
            while (!myQueue.isEmpty()) {
                val currentNode = myQueue.remove()
                //print("${currentNode.value}  ")

                for (itemNode in currentNode.listConnectedNodes) {
                    if (itemNode.status == GraphNodeStatus.AVAILABLE) {
                        itemNode.status = GraphNodeStatus.STANDBY
                        println("Added to the queue ${itemNode.value}")
                        myQueue.add(itemNode)
                    }
                }
                currentNode.status = GraphNodeStatus.DONE

            }

        }
    }

    private class Grapho {
        val listNodes: ArrayList<GraphNode> = ArrayList()
    }

    private class GraphNode(val value: String) {
        var status = GraphNodeStatus.AVAILABLE
        val listConnectedNodes: ArrayList<GraphNode> = ArrayList()

    }

    private enum class GraphNodeStatus {
        AVAILABLE, STANDBY, DONE
    }
}
