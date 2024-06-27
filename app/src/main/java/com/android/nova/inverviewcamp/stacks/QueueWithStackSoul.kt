package com.android.nova.inverviewcamp.stacks
/**
 * Level: Medium
 * Implement a Queue using 2 stacks
 */
class QueueWithStackSoul {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Creating queue class...")
            val queue = Queue()
            queue.add(1)
            queue.add(2)
            queue.add(3)

            queue.display()

            println("Remove the last one")
            queue.remove()
            queue.display()
        }
    }

    private class Queue {
        val leftStack = Stack()
        val rightStack = Stack()

        fun add(value: Int) {
            leftStack.push(value)
        }

        fun display() {
            // Print left stack from head
            leftStack.displayFromHead()

            // Print right stack from tail
            rightStack.displayFromTail()
        }

        fun remove() {
            var currentPeek = leftStack.peek()
            // Move everything from left to right
            while (leftStack.pop()) {
                if (currentPeek != null) {
                    rightStack.push(currentPeek)
                }
                currentPeek = leftStack.peek()
            }
           rightStack.pop()
        }
    }

    private class Stack {
        private val myLinkedList = AuxLinkedList()

        fun push(value: Int) {
            myLinkedList.add(value)
        }

        fun pop():Boolean {
            return myLinkedList.remove()
        }

        fun peek(): Int? {
            return myLinkedList.tail?.value
        }

        fun displayFromHead() {
            myLinkedList.displayFromHead()
        }
        fun displayFromTail() {
            myLinkedList.displayFromTail()
        }
    }
}