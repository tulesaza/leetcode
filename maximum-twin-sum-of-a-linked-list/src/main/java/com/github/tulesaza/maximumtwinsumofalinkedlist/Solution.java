package com.github.tulesaza.maximumtwinsumofalinkedlist;


import com.github.tulesaza.leetcodelinkedlist.ListNode;

class Solution {
    // Time O(n), space O(1)
    //           m
    // 1 -> 2 -> 3 -> 4  find mid
    // 1 -> 2 -> 3 -> null   reverse list
    //   null <- 3 <- 4
    // 1 + 4 vs 1 + 3  two pointer
    public int pairSum(ListNode head) {
        // find mid
        ListNode mid = head, fast = head;
        while (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }
        // reverse list
        ListNode tail = mid, current = tail.next;
        while (current != null) {
            ListNode next = current.next;
            current.next = tail;
            tail = current;
            current = next;
        }
        mid.next = null;

        // two pointers
        int maxSum = 0;
        while (tail != null) {
            maxSum = Math.max(maxSum, head.val + tail.val);
            head = head.next;
            tail = tail.next;
        }

        return maxSum;
    }
}
