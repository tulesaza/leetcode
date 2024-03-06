package com.github.tulesaza.linkedlistcycle;

import com.github.tulesaza.leetcodelinkedlist.ListNode;

/*
 * 5 -> 3 -> 1 -> 2
 *      1_________|
 * f,s
 *      s    f
 *      f    s
 *                s,f
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
