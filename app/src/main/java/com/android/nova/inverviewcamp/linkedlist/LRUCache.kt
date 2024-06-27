package com.android.nova.inverviewcamp.linkedlist
/**
 * Least Recently Used Cache
 *
 * Level: Hard
 * Implement a data structure for a Least Recently Used (LRU) cache.
 */
class LRUCache {
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
        var size: Int = 5
        var head: Node?
        var tail: Node?
        var mapNodes: HashMap<Int, Node>
        init {
            head = null
            tail = null
            mapNodes = HashMap<Int, Node>()

        }

        fun addValues(inputArray: IntArray) {
            for (i in inputArray.indices) {
                addSingleValue(inputArray[i])
            }
            print()
        }

        fun addSingleValue(value: Int) {
            val node = Node(value, null)
            if (head == null) {
                head = node
            }
            if (tail != null) {
                tail?.nextNode = node
            }

            tail = node

            if (mapNodes.size >= 5) {
                if (mapNodes.containsKey(value)) {
                    // remove the current node
                    val nextNode = mapNodes.get(value)
                    head = nextNode
                    mapNodes.remove(value)
                    head = head?.nextNode
                } else {
                    mapNodes.remove(head?.value)
                    head = head?.nextNode
                }
                mapNodes[value] = node
            } else {
                mapNodes[value] = node
            }
        }

        fun print() {
            var currentNode = head
            while (currentNode != null) {
                print("${currentNode.value}, ")
                currentNode = currentNode.nextNode
            }
            println("")
        }

    }

    private class Node (var value:Int?, var nextNode: Node?)
}