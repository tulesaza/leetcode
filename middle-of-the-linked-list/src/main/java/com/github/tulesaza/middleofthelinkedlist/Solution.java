package com.github.tulesaza.middleofthelinkedlist;

import com.github.tulesaza.leetcodelinkedlist.ListNode;

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}