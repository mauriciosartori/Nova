package com.android.nova.inverviewcamp.linkedlist
/**
 * Implement a linked list como Dios te de a entender
 * JDK The linked list should be able to do the following:
 * - Add elements
 * - Delete the last element
 * - Print the full linked list
 */
class LinkedListImplementation {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("This is the linkedin implementation")
            println("We are adding the following elements to the List")
            println("1,5,7,9,11,17,19,21")
            val linkedList = createLinkedList(intArrayOf(1,5,7,9,11,17,19,21))
            println("List created")
            printLinkedList(linkedList)

        }
        fun createLinkedList(inputArray: IntArray): Node {
            val lastIndex = inputArray.size - 1
            var prevNode = Node(inputArray[lastIndex], null)
            for (i in lastIndex - 1 downTo 0) {
                val nodeItem = Node(inputArray[i], prevNode)
                prevNode = nodeItem
            }
            return prevNode
        }

        fun printLinkedList(head:Node?){
            var currentNode = head
            println("Elements in the list")
            while (currentNode?.nextNode != null) {
                print("${currentNode.value}, ")
                currentNode = currentNode.nextNode
            }
            print("${currentNode?.value} ")
        }
    }
    class Node (val value: Int, val nextNode: Node?)
}