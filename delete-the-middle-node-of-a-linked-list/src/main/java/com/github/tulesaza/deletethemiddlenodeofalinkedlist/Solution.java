package com.github.tulesaza.deletethemiddlenodeofalinkedlist;

import com.github.tulesaza.leetcodelinkedlist.ListNode;

class Solution {
    /*
     * Input: head = [1,2,3,4]
     *
     *  0 -> 1 -> 2 -> 3 -> 4 -> null
     *  s    f
     *       s         f
     *            s               f = null
     *  s.next -> 3, to be removed
     * Output: head = [1,2,4]
     *
     */
    public ListNode deleteMiddle(ListNode head) {
        ListNode fakeZero = new ListNode(0, head);
        ListNode fast = head, slow = fakeZero;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return fakeZero.next;
    }
}
