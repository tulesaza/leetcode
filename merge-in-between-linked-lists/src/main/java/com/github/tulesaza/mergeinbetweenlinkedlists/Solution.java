package com.github.tulesaza.mergeinbetweenlinkedlists;

import com.github.tulesaza.leetcodelinkedlist.ListNode;

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode fromExcl = list1;
        int inx = 0;
        while (++inx < a) {
            fromExcl = fromExcl.next;
        }
        ListNode toExcl = fromExcl.next;
        while (inx++ <= b) {
            toExcl = toExcl.next;
        }

        fromExcl.next = list2;
        ListNode last = list2;
        while (last.next != null) {
            last = last.next;
        }
        last.next = toExcl;
        return list1;
    }
}