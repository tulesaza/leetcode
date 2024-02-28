package com.github.tulesaza.leetcodebinarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public static TreeNode fromList(List<Integer> list) {
        return fromList(list, 0);
    }

    private static TreeNode fromList(List<Integer> list, int index) {
        if (index >= list.size() || list.get(index) == null) {
            return null;
        }
        return new TreeNode(list.get(index), fromList(list, index * 2 + 1), fromList(list, index * 2 + 2));
    }

    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>();
        Deque<Optional<TreeNode>> queue = new ArrayDeque<>();
        queue.offer(Optional.of(this));
        while (!queue.isEmpty()) {
            var current = queue.poll();

            if (current.isEmpty()) {
                list.add(null);
                continue;
            }
            list.add(current.get().val);
            if (current.get().left != null || current.get().right != null) {
                queue.offer(Optional.ofNullable(current.get().left));
                queue.offer(Optional.ofNullable(current.get().right));
            }

        }

        return list;
    }

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}