package com.github.tulesaza.reorderlist;

import com.github.tulesaza.leetcodelinkedlist.ListNode;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    // 1. Find mid, put from mid to end to stack O(n), O(n)
    public void reorderList1(ListNode head) {
        if (head == null) return;
        ListNode mid = head, fast = head;
        while (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }

        Deque<ListNode> stack = new LinkedList<>();
        ListNode ptr = mid.next;
        while (ptr != null) {
            stack.push(ptr);
            ptr = ptr.next;
        }
        mid.next = null;
        while (head != mid && !stack.isEmpty()) {
            ListNode nNode = stack.pop();
            ListNode next = head.next;
            nNode.next = next;
            head.next = nNode;
            head = next;
        }
    }

    // 2. Find mid, reverse from mid, 2 pointers O(n), O(1)
    public void reorderList2(ListNode head) {
        if (head == null) return;
        ListNode mid = head, fast = head;
        while (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }

        ListNode tail = mid, current = mid.next;
        while (current != null) {
            ListNode next = current.next;
            current.next = tail;
            tail = current;
            current = next;
        }
        mid.next = null;

        while (head != mid && tail != mid) {
            ListNode nextHead = head.next;
            ListNode nextTail = tail.next;
            head.next = tail;
            tail.next = nextHead;
            head = nextHead;
            tail = nextTail;
        }
    }
}
