package com.android.nova.inverviewcamp.stacks
/**
 * Level: Easy
 * Find if a given number N exists in a stack S.
 */
class FindAElement {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Find the number that is on the stack")
            val myStack = Stack()
            myStack.push(3)
            myStack.push(1)
            myStack.push(2)
            myStack.push(4)
            myStack.push(7)
            myStack.push(9)
            myStack.push(11)
            myStack.push(17)
            myStack.push(19)

            myStack.display()
            val elementToRemove = 9
            println("Looking for the lucky $elementToRemove")

            myStack.lookAndRemove(elementToRemove)
            println("The result is ")
            myStack.display()

        }
    }
    private class Stack {
        val myLinkedList: LinkedList
        init {
            myLinkedList = LinkedList()
        }

        fun push(value:Int?) {
            if (value != null) {
                myLinkedList.addItem(value)
            }
        }

        fun lookAndRemove(value: Int) {
            val tempStack = Stack()
            var foundElement = false

            while (peek() != null) {
                val peekNode = peek()
                if (peekNode?.value == value) {
                    pop()
                    foundElement = true
                    break

                }
                tempStack.push(peekNode?.value)
                pop()
            }
            if (!foundElement) {
                myLinkedList.head = null
            }

            while (tempStack.peek() != null) {
                push(tempStack.peek()?.value)
                tempStack.pop()
            }
            println("The element was found and removed? ${foundElement}")

        }

        fun pop() {
            myLinkedList.remove()
        }

        fun peek():Node? {
            return myLinkedList.tail
        }

        fun display() {
            myLinkedList.print()
        }
    }
    private class LinkedList {
        var head: Node?
        var tail: Node?

        init {
            head = null
            tail = null
        }

        fun addItem(value: Int) {
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

        fun remove() {
            if (tail == null) {
                println("Not to much stuff to remove, sorry")
                return
            }
            val currentTail = tail
            tail?.prevNode?.nextNode = null
            tail = tail?.prevNode
            currentTail?.prevNode = null
        }

        fun print() {
            var node = head
            while (node != null) {
                print("${node.value}, ")
                node = node.nextNode
            }
            println(" ")
        }
    }
    private class Node(var value:Int, var prevNode: Node?, var nextNode: Node?)
}