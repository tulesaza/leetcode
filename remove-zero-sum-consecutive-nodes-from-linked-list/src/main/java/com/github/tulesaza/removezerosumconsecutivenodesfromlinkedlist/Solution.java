package com.github.tulesaza.removezerosumconsecutivenodesfromlinkedlist;

import com.github.tulesaza.leetcodelinkedlist.ListNode;

import java.util.HashMap;
import java.util.Map;

class Solution {

    // O(n) time, O(n) space, memorize prefix sum
    public ListNode removeZeroSumSublists1(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        Map<Integer, ListNode> prefixSumTillNodeIncl = new HashMap<>();
        int prefixSum = 0;
        ListNode current = dummy;
        while (current != null) {
            prefixSum += current.val;
            prefixSumTillNodeIncl.put(prefixSum, current);
            current = current.next;
        }
        prefixSum = 0;
        current = dummy;
        while (current != null) {
            prefixSum += current.val;
            current.next = prefixSumTillNodeIncl.get(prefixSum).next;
            current = current.next;
        }
        return dummy.next;
    }

    // Brute force O(n^2-1/2), O(1)
    public ListNode removeZeroSumSublists2(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy, right;
        while (left != null && left.next != null) {
            right = left.next;
            int sum = 0;
            while (right != null) {
                sum += right.val;
                if (sum == 0) {
                    left.next = right.next;
                }
                right = right.next;
            }

            left = left.next;
        }
        return dummy.next;
    }


}