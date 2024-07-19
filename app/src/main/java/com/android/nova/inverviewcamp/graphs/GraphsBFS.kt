package com.android.nova.inverviewcamp.graphs

import java.util.LinkedList


/**
 * Print Graph in Level Order:
 * Given a graph and a node N, print the Graph in order of distance from N.
 * All nodes of distance 1 from N, followed by nodes of distance 2 from N, etc.
 */
class GraphsBFS {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Printing a Graph with in different levels")
            printGraphLevels()
        }

        fun printGraphLevels() {
            val localGraph = InPlaceGraph()
            var startNode = localGraph.listNodes[0]
            startNode.status = LocalGraphStatus.STANDBY

            val localQueue: LinkedList<LocalGraphNode> = LinkedList()
            localQueue.add(startNode)
            localQueue.add(LocalGraphNode("\n"))


            while (!localQueue.isEmpty()) {
                val myNode = localQueue.remove()

                if (myNode.value.equals("\n")) {
                    if(!localQueue.isEmpty()) {
                        localQueue.add(LocalGraphNode("\n"))
                    }
                    print("${myNode.value}, ")
                    continue
                }

                for (itemNode in myNode.listConnectedNodes) {
                    if (itemNode.status == LocalGraphStatus.AVAILABLE) {
                        itemNode.status = LocalGraphStatus.STANDBY
                        localQueue.add(itemNode)
                    }
                }


                myNode.status = LocalGraphStatus.DONE
                print("${myNode.value}, ")

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

            nodeE.listConnectedNodes.add(nodeC)

            listNodes.add(nodeA)

        }
    }
}