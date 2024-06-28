package com.android.nova.inverviewcamp.stacks
/**
 * Aux List to be used in classes at this package
 */
internal class AuxLinkedListChars {
    var head: NodeChar?
    var tail: NodeChar?

    init {
        head = null
        tail = null
    }

    fun add(value: Char) {
        val node = NodeChar(value, null, null)
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
        if (newTail == null) {
            head = null
            tail = null
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

class NodeChar(var value: Char, var prevNode: NodeChar?, var nextNode: NodeChar?)