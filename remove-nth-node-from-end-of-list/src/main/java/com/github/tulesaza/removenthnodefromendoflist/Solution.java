package com.github.tulesaza.removenthnodefromendoflist;

import com.github.tulesaza.leetcodelinkedlist.ListNode;

class Solution {
    /*                     2    1
     * d -> 1 -> 2 -> 3 -> 4 -> 5 -> null, n = 2
     * s         f
     *______________________________
     * d -> 1 -> 2 -> 3 -> 4 -> 5 -> null
     *      s         f
     *.....      s         f
     *______________________________
     * 1 -> 2 -> 3 -> 4 -> 5 -> null
     *           s         f.next -> null
     * ______________________________
     * 1 -> 2 -> 3 ->   -> 5
     */


    // 1->2 n=2
    // 0 -> 1 -> 2
    // s,f
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;

        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}