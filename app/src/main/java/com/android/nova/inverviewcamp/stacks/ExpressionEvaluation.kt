package com.android.nova.inverviewcamp.stacks

import kotlin.math.exp

/**
 * Level:Hard
 * Given an arithmetic expression with*,/,-&+
 * operators and single digit numbers, evaluate it
 * and return the result. For example,
 * 1 + 2 / 1 + 3 * 2 ==> 9
 */
class ExpressionEvaluation {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val expression = "1+2/1+3*2"
            println("The following is a evaluation of a expression and the I'll go to grab a coffee or something")
            println("The expression to evaluate is ${expression}")
            evaluateExpression(expression)
        }

        fun evaluateExpression(expression:String) {
            val mainStack = Stack()
            for (i in 0..expression.length - 1 ) {
                mainStack.push(expression[i])
            }
            mainStack.drainOperatorStack()
            mainStack.printInternalStacks()
        }
    }
    private class Stack {
        val stackNumbers: AuxLinkedListChars = AuxLinkedListChars()
        val stackOperators: AuxLinkedListChars = AuxLinkedListChars()

        fun printInternalStacks() {
            printSingleStack("numbers", stackNumbers)
            printSingleStack("operators", stackOperators)
        }

        fun printSingleStack(title:String, stack: AuxLinkedListChars ) {
            println("For the $title stack I have")
            var currentNode = stack.head
            while (currentNode != null) {
                print("${currentNode.value}, ")
                currentNode = currentNode.nextNode
            }
            println(" ")
        }

        fun push(char: Char) {
            if (isANumber(char)) {
                // Push the value to the numbers values
                stackNumbers.add(char)

            } else {
                val currentOperator = char
                // Push the value to the operators value
                if (hasMorePriorityThanPrev(currentOperator, stackOperators.tail?.value)) {
                    // if the current operator has more priority than the prev one, just add it
                    stackOperators.add(char)
                } else {
                    //Before to added do some operations here until empty the stacks
                    drainOperatorStack()
                    stackOperators.add(char)
                }
            }
        }

        fun drainOperatorStack() {
            var currentOperator = stackOperators.tail
            while (currentOperator != null) {
                stackOperators.remove()
                val firstDigit = stackNumbers.tail
                stackNumbers.remove()
                val secondDigit = stackNumbers.tail
                stackNumbers.remove()
                val result = evaluateExpression(firstDigit?.value, currentOperator.value, secondDigit?.value)
                if (result != null) {
                    stackNumbers.add(result)
                }
                currentOperator = stackOperators.tail
            }
        }

        fun evaluateExpression(a: Char?, op: Char, b: Char?): Char? {
            if (a == null || b == null) {
                return null
            }
            val num1 = a.toString().toInt()
            val num2 = b.toString().toInt()

            val result = when (op) {
                '+' -> num1 + num2
                '-' -> num1 - num2
                '*' -> num1 * num2
                '/' -> num2 / num1
                '%' -> num1 % num2
                else -> throw IllegalArgumentException("Unknown operator")
            }
            return result.toString().first()
        }

        fun hasMorePriorityThanPrev(currentOperator: Char, prevOperator: Char?): Boolean {
            if (prevOperator == null) {
                return true
            }
            if (currentOperator == '+' && (prevOperator == '*' || prevOperator == '/')) {
                return false
            }
            if (currentOperator == '-' && (prevOperator == '*' || prevOperator == '/')) {
                return false
            }
            return true
        }

        fun isANumber(char:Char):Boolean {
            return char.isDigit()
        }
    }
}