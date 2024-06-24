package com.android.nova.inverviewcamp.linkedlist
/**
 * (Level: Easy) You are given a Linked List with nodes that have values 0, 1 or 2. Sort the linked list. For example,
 *
 * Input: 1 -> 0 -> 2 -> 1 -> 2 -> 1
 * Output: 0 -> 1 -> 1 -> 1 -> 2 -> 2
 */
class AppendElements {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("LinkedList Implementation")
            val lily = LinkedList(1)
            lily.appendValues(intArrayOf(0,2,1,2,1,0,0,0,1,2,2,1,1,1,1))
            lily.printLinkedList()
            sortList(lily)
        }

        private fun sortList(mainLinkedList: LinkedList) {
            val linkedList0 =  LinkedList()
            val linkedList1 =  LinkedList()
            val linkedList2 =  LinkedList()

            var currentNode = mainLinkedList.head
            while (currentNode != null) {
                when (currentNode.value){
                    0 -> linkedList0.addValue(0)
                    1 -> linkedList1.addValue(1)
                    2 -> linkedList2.addValue(2)
                }
                currentNode = currentNode.nextNode
            }

            linkedList0.appendLists(linkedList1)
            linkedList0.appendLists(linkedList2)
            println("The final list looks like this: ")
            linkedList0.printLinkedList()
        }
    }
     private class LinkedList {
        var head: Node?
        var tail: Node?

        constructor(initValue: Int) {
            val initNode = Node(initValue, null)
            head = initNode
            tail = initNode
        }

         constructor() {
             head = null
             tail = null
         }

        fun appendValues(inputArray: IntArray) {
            for (i in inputArray.indices) {
                addValue(inputArray[i])
            }
        }

        fun addValue(value: Int) {
            val valueNode = Node(value, null)
            if (head == null) {
                head = valueNode
            }
            tail?.nextNode = valueNode
            tail = valueNode
        }

         fun appendLists(linkedListToAppend: LinkedList) {
             tail?.nextNode = linkedListToAppend.head
             tail = linkedListToAppend.tail
         }

        fun printLinkedList() {
            println("The printed list is: ")
            var currentNode = head
            while (currentNode?.nextNode != null) {
                print("${currentNode.value}, ")
                currentNode = currentNode.nextNode
            }
            print("${currentNode?.value}, ")
            println("")
        }
    }
    class Node(val value: Int, var nextNode: Node?)
}