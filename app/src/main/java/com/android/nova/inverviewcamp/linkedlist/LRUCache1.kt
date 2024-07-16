package com.android.nova.inverviewcamp.linkedlist
/**
 * Least Recently Used Cache
 *
 * Level: Hard
 * Implement a data structure for a Least Recently Used (LRU) cache.
 */
class LRUCache1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Implementing a LRU Cache system")
            val myLinkedList = LinkedList()
            myLinkedList.addValues(intArrayOf(1,2,3,4,5))
            println("This happens if I add a 1 to the current one")
            myLinkedList.addSingleValue(1)
            myLinkedList.print()
            myLinkedList.addSingleValue(6)
            myLinkedList.print()
            myLinkedList.addSingleValue(3)
            myLinkedList.print()
        }
    }

    private class LinkedList {
        var head:Node? = null
        var tail:Node? = null
        fun addSingleValue(value: Int) {
            val node = Node(value, null)
            if (head == null) {
                head = node
            }
            if (tail != null) {
                tail?.nextNode = node
            }
            tail = node
        }

        fun addValues(inputArray: IntArray) {
            for (i in inputArray.indices) {
                addSingleValue(inputArray[i])
            }
        }

        fun print() {
            var currentNode = head
            while (currentNode != null) {
                print("${currentNode.value}, ")
                currentNode = currentNode.nextNode
            }
            println(" ")
        }

    }

    private class Node(var value:Int, var nextNode: Node?)
}