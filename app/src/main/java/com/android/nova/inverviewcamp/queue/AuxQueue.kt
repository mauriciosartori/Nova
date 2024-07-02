package com.android.nova.inverviewcamp.queue
/**
 *
 */
abstract class AuxQueue {
    protected val myLinkedList = LinkedList()

    var size = 0
    fun add(value: Int) {
        myLinkedList.add(value)
        size++
    }

    fun remove() {
        myLinkedList.remove()
        size--
    }

    abstract fun getSlidingWindowsSums(inputArray: IntArray, target: Int)

    fun display() {
        myLinkedList.display()
    }

    fun peak(): Int{
        val tailNode = myLinkedList.tail ?: return 0
        return tailNode.value
    }
}

class LinkedList {
        var head: Node? = null
        var tail: Node? = null

        fun add(value: Int) {
            val myNode = Node(value, null, tail)
            if (head == null) {
                head = myNode
                tail = myNode
                return
            }
            tail?.nextNode = myNode
            tail = myNode
        }

        fun remove():Int?{
            if (tail == head) {
                val tailValueToReturn = tail?.value
                head = null
                tail = null
                return tailValueToReturn
            }
            val tailValueToReturn = tail?.value
            val newTail = tail?.prevNode
            newTail?.nextNode = null
            tail?.prevNode = null
            tail = newTail
            return tailValueToReturn
        }

        fun display() {
            var currentNode = head
            while (currentNode != null) {
                print("${currentNode.value}, ")
                currentNode = currentNode.nextNode
            }

        }
}

class Node (var value: Int, var nextNode: Node?, var prevNode: Node?)