package com.github.tulesaza.leetcodelinkedlist;

import java.util.List;

public interface ListCreator {

    ListNode fromList(List<Integer> list);

    List<Integer> toList(ListNode start);
}
