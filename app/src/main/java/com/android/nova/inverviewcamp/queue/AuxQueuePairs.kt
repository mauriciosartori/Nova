package com.android.nova.inverviewcamp.queue
/**
 *
 */
open class AuxQueuePairs {
    protected val myLinkedList = LinkedListBeta()

    var size = 0
    fun add(value: Pair<Int, Int>) {
        myLinkedList.add(value)
        size++
    }

    fun remove() {
        myLinkedList.remove()
        size--
    }

    fun display() {
        myLinkedList.display()
    }
}

class LinkedListBeta {
        var head: NodeBeta? = null
        var tail: NodeBeta? = null

        fun add(value: Pair<Int, Int>) {
            val myNode = NodeBeta(value, null, tail)
            if (head == null) {
                head = myNode
                tail = myNode
                return
            }
            tail?.nextNode = myNode
            tail = myNode
        }

        fun remove():Pair<Int, Int>?{
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

class NodeBeta (var value: Pair<Int, Int>, var nextNode: NodeBeta?, var prevNode: NodeBeta?)