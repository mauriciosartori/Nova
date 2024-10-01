package com.android.nova.leetcode.blind75Test.daillypracticedos
/**
 *
 */
class No2 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            var nodeAhead = head
            for (i in 0 until n) {
                nodeAhead = nodeAhead?.next
            }
            if (nodeAhead == null) {
                val newHead = head?.next
                return newHead
            }

            var nodeToDelete = head
            var prevNode = head
            while (nodeAhead != null) {
                prevNode = nodeToDelete
                nodeToDelete = nodeToDelete?.next
                nodeAhead = nodeAhead?.next
            }
            val nodeB = nodeToDelete?.next
            nodeToDelete?.next = null
            prevNode?.next = nodeB
            return head
        }
    }
}