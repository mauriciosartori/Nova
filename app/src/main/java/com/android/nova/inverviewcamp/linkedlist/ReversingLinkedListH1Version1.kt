package com.android.nova.inverviewcamp.linkedlist
/**
 * Level: Medium
 * Is Palindrome: Given a Linked List, determine if it is a Palindrome.
 * For example, the following lists are palindromes:
 * A -> B -> C -> B -> A
 * A -> B -> B -> A
 * K -> A -> Y -> A -> K
 * Note: Do it with O(N) time and O(1) space? (Hint: Reverse a part of the lis
 */
class ReversingLinkedListH1Version1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Reversing a linked list")
            val myLinkedList = LinkedList()
            myLinkedList.addValues(charArrayOf('K', 'A', 'Y', 'A', 'K'))
            myLinkedList.printValues()
            println("alter a serious analysis, is this a palindrome? ${myLinkedList.isPalindrome()}" )
        }
    }
    private class LinkedList {
        var head: Node?
        var tail: Node?

        init {
            head = null
            tail = null
        }

        fun addValues(inputArray: CharArray) {
            for (i in inputArray.indices) {
                addNode(inputArray[i])
            }
        }

        fun addNode(value: Char) {
            val node = Node(value, null)
            if (head == null) {
                head = node
            }
            if (tail != null) {
                tail?.nextNode = node
            }
            tail = node
        }

        fun isPalindrome():Boolean{
            val middleNode = getMiddle()

            reverseMiddleList(middleNode)

            var leftSide = head
            var rightSide = middleNode?.nextNode
            while (leftSide != null && rightSide != null) {
                if (leftSide.value != rightSide.value) {
                    return false
                }
                leftSide = leftSide?.nextNode
                rightSide = rightSide?.nextNode
            }
            return true
        }

        fun reverseMiddleList(middleNode: Node?) {
            var prev:Node? = null
            var current = head
            while (current != middleNode) {
                val next = current?.nextNode

                current?.nextNode= prev
                prev = current
                current = next
            }
            head = prev
        }

        fun getMiddle():Node? {
            var slowPointer = head
            var fastPointer = head
            while (fastPointer != null) {
                fastPointer = fastPointer?.nextNode
                fastPointer = fastPointer?.nextNode
                if (fastPointer != null) {
                    slowPointer = slowPointer?.nextNode
                }
            }
            println("The middle pointer is ${slowPointer?.value}")
            return slowPointer
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

    private class Node(var value: Char?, var nextNode: Node?)
}