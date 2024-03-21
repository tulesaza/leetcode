package com.github.tulesaza.reverselinkedlist;

import com.github.tulesaza.leetcodelinkedlist.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode prevNext = current.next;
            current.next = prev;
            prev = current;
            current = prevNext;

        }
        return prev;
    }

    // 1 - 2 - 3 - 4
    public ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}