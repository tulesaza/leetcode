package com.github.tulesaza.leetcodelinkedlist;

import java.util.ArrayList;
import java.util.List;

public class LeetcodeListCreator implements ListCreator {

    @Override
    public ListNode fromList(List<Integer> list, int cyclePosition) {
        ListNode start = null;
        ListNode tail = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            start = new ListNode(list.get(i), start);
            if (i == list.size() - 1) {
                tail = start;
            }
            if (i == cyclePosition && tail != null) {
                tail.next = start;
            }
        }
        return start;
    }

    @Override
    public ListNode fromList(List<Integer> list) {

        return fromList(list, -1);
    }

    @Override
    public List<Integer> toList(ListNode start) {
        List<Integer> result = new ArrayList<>();
        ListNode current = start;
        while (current != null) {
            result.add(current.val);
            current = current.next;
        }
        return result;
    }
}
