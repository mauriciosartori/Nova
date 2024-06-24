package com.android.nova.inverviewcamp.linkedlist
/**
 * Delete NodeLevel: Medium
 * Given a linked list and pointers to a node N and its previous node Prev,
 * delete N from the linked list.
 */
class DeleteNode {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Creating the linked list")
            val linkedSample = LinkedList()
            linkedSample.appendValues(intArrayOf(1,5,7,9,11,14,17,19,21,27))
            linkedSample.print()

            println("Now we are trying to delete 1")
            linkedSample.removeNode(1)

            println("After this we are deleting the 27")
            linkedSample.removeNode(27)

            println("Ok finally the case when we are deleting something from the middle")
            linkedSample.removeNode(14)
        }
    }

    private class LinkedList {
        var head: Node?
        var tail: Node?
        init {
            head = null
            tail = null
        }

        fun appendValue(value: Int) {
            val value = Node(value, null)
            if (head == null) {
                head = value

            }
            tail?.nextNode = value
            tail = value
        }

        fun appendValues(inputArray: IntArray) {
            for (i in inputArray.indices) {
                appendValue(inputArray[i])
            }
        }

        fun removeNode(target:Int) {
            var currentNode = head
            var prevNode:Node? = null

            while (currentNode != null) {
                if (currentNode.value == target) {
                    when (currentNode) {
                        head -> {
                            // create a new head and remove the current one
                            val tempNextNode = head?.nextNode
                            head?.nextNode = null
                            head = tempNextNode
                        }
                        tail -> {
                            // Remove the current tail and define a new one
                            prevNode?.nextNode = null
                            tail = prevNode
                        }
                        else -> {
                            // The node is in the middle do a different approach
                            val upcomingNode = currentNode.nextNode
                            currentNode.value = upcomingNode?.value
                            val upcomingNodeRef = upcomingNode?.nextNode
                            upcomingNode?.nextNode = null
                            currentNode.nextNode = upcomingNodeRef
                        }
                    }
                }
                prevNode = currentNode
                currentNode = currentNode.nextNode
            }
            print()
        }

        fun print() {
            println("The values inside the list are:")
            var currentNode = head
            while (currentNode != null) {
                if (currentNode.value != null) {
                    print("${currentNode.value} ,")
                    currentNode = currentNode.nextNode
                }
            }
            println("")
        }

    }
    private class Node(var value:Int?, var nextNode: Node?)
}