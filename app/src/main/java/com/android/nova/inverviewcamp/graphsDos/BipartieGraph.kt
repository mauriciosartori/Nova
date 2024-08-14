package com.android.nova.inverviewcamp.graphsDos

import java.util.LinkedList
import java.util.Queue

/**
 * Given a graph,separate nodes into 2 groups,
 * such that no 2 nodes in the same group have an edge
 */
class BipartieGraph {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Separating a Bipartie Graph")
            val nodeA = NodeDosV1("A")
            val nodeB = NodeDosV1("B")
            val nodeC = NodeDosV1("C")
            val nodeD = NodeDosV1("D")
            val nodeE = NodeDosV1("E")
            val nodeF = NodeDosV1("F")
            val nodeG = NodeDosV1("G")
            val nodeH = NodeDosV1("H")

            // Working on the connections
            nodeA.listNodes.add(nodeB)
            nodeA.listNodes.add(nodeC)
            nodeA.listNodes.add(nodeD)

            nodeB.listNodes.add(nodeA)
            nodeB.listNodes.add(nodeE)
            nodeB.listNodes.add(nodeH)

            nodeC.listNodes.add(nodeF)
            nodeC.listNodes.add(nodeE)
            nodeC.listNodes.add(nodeA)

            nodeD.listNodes.add(nodeH)
            nodeD.listNodes.add(nodeF)
            nodeD.listNodes.add(nodeA)

            nodeE.listNodes.add(nodeC)
            nodeE.listNodes.add(nodeG)
            nodeE.listNodes.add(nodeB)

            nodeF.listNodes.add(nodeG)
            nodeF.listNodes.add(nodeC)
            nodeF.listNodes.add(nodeD)

            nodeG.listNodes.add(nodeH)
            nodeG.listNodes.add(nodeF)
            nodeG.listNodes.add(nodeE)

            nodeH.listNodes.add(nodeD)
            nodeH.listNodes.add(nodeG)
            nodeH.listNodes.add(nodeB)

            GraphDosV1(nodeA)

            separateGroups(nodeA)
        }

        fun separateGroups(mainNode:NodeDosV1 ) {
            var level = 0
            mainNode.state = StateDosV1.VISITING
            mainNode.level = level

            val listEven:MutableList<NodeDosV1> = arrayListOf()
            val listOdd:MutableList<NodeDosV1> = arrayListOf()

            // Create a queue
            val myQueue = LinkedList<NodeDosV1>()
            myQueue.add(mainNode)

            while (!myQueue.isEmpty()) {
                val currentNode = myQueue.remove()

                if (currentNode.level % 2 == 0) {
                    listEven.add(currentNode)
                } else {
                    listOdd.add(currentNode)
                }

                for (itemNode in currentNode.listNodes) {
                    if (itemNode.state == StateDosV1.AVAILABLE) {
                        itemNode.level = currentNode.level + 1
                        itemNode.state = StateDosV1.VISITING
                        myQueue.add(itemNode)
                    }
                }
            }
            println("At the end of the day the lists are the follow")
            println("Even nodes")
            for (evenItem in listEven) {
                print("${evenItem.value}, ")
            }
            println("")
            println("Odd nodes")
            for (oddItem in listOdd) {
                print("${oddItem.value}, ")
            }
        }
    }



    class GraphDosV1(node:NodeDosV1)

    class NodeDosV1(val value:String, val listNodes:ArrayList<NodeDosV1> = arrayListOf(), var state:StateDosV1 = StateDosV1.AVAILABLE, var level:Int = 0 )

    enum class StateDosV1 {AVAILABLE, VISITING, VISITED }
}