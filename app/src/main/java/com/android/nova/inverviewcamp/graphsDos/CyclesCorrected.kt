package com.android.nova.inverviewcamp.graphsDos

import java.util.Stack

/**
 *
 */
class CyclesCorrected {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Detecting cycles in s graph")
            val mainNodeA = NodeDos("A")
            val nodeB = NodeDos("B")
            val nodeC = NodeDos("C")
            val nodeD = NodeDos("D")
            val nodeE = NodeDos("E")

            mainNodeA.nodesLists.add(nodeB)
            nodeB.nodesLists.add(nodeD)
            nodeB.nodesLists.add(nodeE)
            nodeD.nodesLists.add(nodeC)
            nodeD.nodesLists.add(nodeE)
            nodeC.nodesLists.add(nodeB)
            val graph = GraphDos(mainNodeA)
            findCycleStart(graph)
        }

        fun findCycleStart(graph: GraphDos) {
            findCycleSingle(graph.mainNode)
        }
        fun findCycleSingle(mainNode: NodeDos) {
            mainNode.state = StateTwo.VISITING

            for (currentNode in mainNode.nodesLists) {
                if (currentNode.state == StateTwo.AVAILABLE) {
                    findCycleSingle(currentNode)
                } else if (currentNode.state == StateTwo.VISITING) {
                    println("----")
                    println("On the value of ${currentNode.value}")
                    println("Valio madre la vida")
                    println("----")
                }
                currentNode.state = StateTwo.VISITED
                print("${currentNode.value}, ")
            }
        }
    }

}