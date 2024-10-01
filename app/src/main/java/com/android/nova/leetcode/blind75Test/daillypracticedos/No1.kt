package com.android.nova.leetcode.blind75Test.daillypracticedos
/**
 *
 */
class No1 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            if (head == null) {
                return null
            }
            if (head?.next == null) {
                return null
            }

            var node = head
            var prevNode = head
            while (node != null) {
                var subnode = node
                var positionsAhead = n

                while (positionsAhead > 0) {
                    subnode = subnode?.next
                    positionsAhead--
                    if (subnode == null) {
                        break
                    }
                }

                if (subnode == null) {
                    println(node.`val`)
                    prevNode?.next = node?.next
                    break
                }
                prevNode = node
                node = node.next
            }
            return head
        }
    }
}