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
}