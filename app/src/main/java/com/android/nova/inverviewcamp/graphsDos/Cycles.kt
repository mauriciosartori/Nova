package com.android.nova.inverviewcamp.graphsDos

import java.util.Stack

/**
 *
 */
class Cycles {
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
            findCycle(graph)
        }

        fun findCycle(graph: GraphDos) {
            val mainNode = graph.mainNode
            val stackDfs = Stack<NodeDos>()
            mainNode.state = StateTwo.VISITING
            stackDfs.push(mainNode)

            while (!stackDfs.isEmpty()) {
                val currentNode = stackDfs.pop()
                currentNode.state = StateTwo.VISITING
                for (itemNode in currentNode.nodesLists) {
                    if (itemNode.state == StateTwo.AVAILABLE) {

                        stackDfs.push(itemNode)
                    } else if (itemNode.state == StateTwo.VISITING) {
                        println("On the value of ${itemNode.value}")
                        println("Valio madre la vida")
                    }
                }
                currentNode.state = StateTwo.VISITED
                print("${currentNode.value}, ")
            }
        }
    }

}