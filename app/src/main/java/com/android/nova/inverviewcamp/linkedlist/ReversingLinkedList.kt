package com.android.nova.inverviewcamp.linkedlist
/**
 * Reverse a linked list.You should use O(1) space
 */
class ReversingLinkedList {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Reversing a linked list")
            val myLinkedList = LinkedList()
            myLinkedList.addValues(intArrayOf(1,5,7,9,11,17,19,21))
            myLinkedList.printValues()
            myLinkedList.reverse()
            myLinkedList.printValues()
        }
    }

    private class LinkedList {
        var head: Node?
        var tail: Node?

        init {
            head = null
            tail = null
        }

        fun addValues(inputArray: IntArray) {
            for (i in inputArray.indices) {
                addNode(inputArray[i])
            }
        }

        fun addNode(value: Int) {
            val node = Node(value, null)
            if (head == null) {
                head = node
            }
            if (tail != null) {
                tail?.nextNode = node
            }
            tail = node
        }

        fun reverse(){
            var prev: Node? = null
            var current: Node? = head

            while (current != null) {
                val next = current.nextNode
                current.nextNode = prev
                prev = current
                current = next
            }

            head = prev
        }

        fun printValues() {
            var currentNode = head
            while (currentNode != null) {
                print("${currentNode.value}, ")
                currentNode = currentNode.nextNode
            }
            println("")
        }
    }

    private class Node(var value: Int?, var nextNode: Node?)
}