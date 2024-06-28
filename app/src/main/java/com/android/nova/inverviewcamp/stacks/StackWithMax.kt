package com.android.nova.inverviewcamp.stacks

import com.android.nova.inverviewcamp.linkedlist.LinkedListImplementation

/**
 * (Level: Medium) Implement a Stack with O(1) lookup of the maximum element in the stack. For example,
 *
 * Stack: 3 -> 2 -> 1 -> 5
 * Max() => 5
 *
 * After 1 pop():
 * Stack: 3 -> 2 -> 1
 * Max() => 3
 */
class StackWithMax {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Stack with max")
            println("I am pushing the following elements 3, 2, 1, 5")
            val myStack = Stack()
            myStack.push(3)
            myStack.push(2)
            myStack.push(1)
            myStack.push(5)
            println("The max value element is ${myStack.max()}")
            myStack.pop()
            println("After the update, the max value element is ${myStack.max()}")
        }
    }

    private class Stack {
        val linkedListValues: AuxLinkedList
        val linkedListMax: AuxLinkedList
        private var maxValue: Int?

        init {
            linkedListValues = AuxLinkedList()
            linkedListMax = AuxLinkedList()
            maxValue = null
        }

        fun push( value: Int) {
            linkedListValues.add(value)
            if (maxValue == null) {
                linkedListMax.add(value)
                maxValue = value
            } else if (value > maxValue!!) {
                maxValue = value
                linkedListMax.add(value)
            }
        }

        fun pop() {
            if (linkedListMax.tail?.value == maxValue) {
                linkedListMax.remove()
                maxValue = linkedListMax.tail?.value
            }
            linkedListValues.remove()
        }

        fun max():Int? {
            return linkedListMax.tail?.value
        }
    }
}