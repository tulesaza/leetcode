package com.github.tulesaza.oddevenlinkedlist;

import com.github.tulesaza.leetcodelinkedlist.ListNode;

class Solution {
    // 1. use structure to keep order O(n) -> forbidden
    // 2. use two pointers, odd and even, O(n) time, O(1) space
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head, even = head.next;
        ListNode mid = even;

        while (odd != null && even != null && even.next != null && odd.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = mid;

        return head;
    }
}