package com.android.nova.inverviewcamp.linkedlist
/**
 * Level: EasyFind if a given Linked List has a cycle
 */
class SlowFastPointer {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Testing the slow and fast pointer")
            val linkList = LinkedList()
            linkList.addNode(3)
            linkList.addNode(5)
            linkList.addNode(1)
            val nodeOneTail= linkList.tail
            linkList.addNode(2)
            linkList.addNode(4)
            linkList.addNode(7)
            linkList.addNode(9)
            //linkList.tail?.nextNode = nodeOneTail

            // linkList.printList()
            println("Determinate if this thing has a cycle and it is ${linkList.hasACycle()}")
            //println("Length of the list ${linkList.getLength()}")
            //println("For the next part the media node is ${linkList.getMediaNode()}")
            println("And finally the third element before the last one is ${linkList.getTheThirdToTheLast()}")



        }
    }
    private class LinkedList {
        var head: Node?
        var tail: Node?

        init {
            head = null
            tail = null
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

        fun hasACycle():Boolean {
            var slowPointer = head
            var fastPointer = head
            while (fastPointer != null) {
                fastPointer= fastPointer.nextNode
                if (fastPointer == slowPointer) {
                    return true
                }
                fastPointer= fastPointer?.nextNode
                if (fastPointer == slowPointer){
                    return true
                }
                slowPointer = slowPointer?.nextNode
            }

            return false
        }

        fun getLength():Int {
            var slowPointer = head
            var fastPointer = head

            while (fastPointer != null) {
                fastPointer = fastPointer.nextNode
                if(fastPointer== slowPointer){
                    break
                }
                fastPointer = fastPointer?.nextNode
                if (fastPointer == slowPointer) {
                    break;
                }
                slowPointer = slowPointer?.nextNode
            }

            fastPointer = fastPointer?.nextNode
            var nodesPassed = 1
            while (fastPointer != slowPointer) {
                fastPointer = fastPointer?.nextNode
                nodesPassed += 1
            }
            return nodesPassed
        }

        fun getMediaNode():Int? {
            var slowPointer = head
            var fastPointer = head

            while (fastPointer != null) {
                fastPointer = fastPointer.nextNode
                if(fastPointer== slowPointer){
                    break
                }
                fastPointer = fastPointer?.nextNode
                if (fastPointer == slowPointer) {
                    break;
                }
                slowPointer = slowPointer?.nextNode
            }

            return slowPointer?.value
        }

        fun getTheThirdToTheLast():Int? {
            var slowPointer = head
            var fastPointer = head

            while (fastPointer != null) {
                fastPointer = fastPointer.nextNode
                fastPointer = fastPointer?.nextNode
                slowPointer = slowPointer?.nextNode
            }

            return slowPointer?.value
        }
        fun printList() {
            var currentNode = head

            while (currentNode != null) {
                print("${currentNode.value}, ")
                currentNode = currentNode.nextNode
            }
            print(" ")
        }
    }

    private class Node(var value: Int, var nextNode: Node?)
}