package com.github.tulesaza.palindromelinkedlist;

import com.github.tulesaza.leetcodelinkedlist.ListNode;

class Solution {

    // Time O(n), space O(1)
    //
    // 1 -> 2 -> 3 -> 4 -> null
    //           m
    // 1 -> 2 -> 3 <- 4
    //
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        // find mid O(n/2)
        ListNode mid = head, fast = head;
        while (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }
        // reverse from mid to tail O(n/2) 1 2 1
        ListNode tail = mid, current = mid.next;
        while (current != null) {
            ListNode next = current.next;
            current.next = tail;
            tail = current;
            current = next;
        }

        // compare head and tail and iterate till mid O(n/2)
        while (head != mid && tail != mid) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return tail.val == head.val;
    }
}
