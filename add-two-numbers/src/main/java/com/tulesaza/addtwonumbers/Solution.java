package com.tulesaza.addtwonumbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        int carry = 0;
        ListNode last = null;
        ListNode result = null;
        do {
            int sum;
            int digit1 = current1 != null ? current1.val : 0;
            int digit2 = current2 != null ? current2.val : 0;
            sum = digit1 + digit2 + carry;
            if (sum > 9) {
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode current = new ListNode(sum);

            if (last == null) {
                result = current;
            } else {
                last.next = current;
            }

            last = current;

            current1 = current1 != null ? current1.next : null;
            current2 = current2 != null ? current2.next : null;

        } while (current1 != null || current2 != null);

        if (carry != 0) {
            last.next = new ListNode(carry);
        }

        return result;
    }

     static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}