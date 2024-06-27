package com.android.nova.inverviewcamp.stacks
/**
 * Aux List to be used in classes at this package
 */
internal class AuxLinkedList {
    var head: Node?
    var tail: Node?

    init {
        head = null
        tail = null
    }

    fun add(value: Int) {
        val node = Node(value, null, null)
        if (head == null) {
            head = node
        }

        if (tail != null) {
            tail?.nextNode = node
            node.prevNode = tail
        }
        tail = node
    }

    fun remove():Boolean {
        val newTail = tail?.prevNode
        if (tail == null) {
            head = null
            return false
        }
        tail?.prevNode = null
        newTail?.nextNode = null
        tail = newTail
        return true
    }

    fun displayFromHead() {
        var currentNode = head
        while (currentNode != null) {
            print("${currentNode.value}, ")
            currentNode = currentNode.nextNode
        }
    }

    fun displayFromTail() {
        var currentNode = tail
        while (currentNode != null) {
            print("${currentNode.value}, ")
            currentNode = currentNode.prevNode
        }
        println("")
    }

}

class Node(var value: Int, var prevNode: Node?, var nextNode: Node?)