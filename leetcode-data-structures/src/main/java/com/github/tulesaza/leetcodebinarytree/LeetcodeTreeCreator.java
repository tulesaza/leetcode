package com.github.tulesaza.leetcodebinarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class LeetcodeTreeCreator implements TreeCreator {
    @Override
    public List<Integer> toList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Deque<Optional<TreeNode>> queue = new ArrayDeque<>();
        int notNullCount = 1;
        queue.offer(Optional.of(root));
        while (!queue.isEmpty()) {
            var current = queue.poll();

            if (current.isEmpty()) {
                if (notNullCount > 0) {
                    list.add(null);
                }
                continue;
            }
            list.add(current.get().val);
            notNullCount--;
            if (current.get().left != null) {
                notNullCount++;
            }
            if (current.get().right != null) {
                notNullCount++;
            }
            queue.offer(Optional.ofNullable(current.get().left));
            queue.offer(Optional.ofNullable(current.get().right));


        }
        return list;
    }

    @Override
    public TreeNode fromList(List<Integer> list) {
        if (list.isEmpty()) return null;
        int index = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(list.getFirst());
        queue.offer(root);
        while (index < list.size()) {
            TreeNode parent = queue.poll();
            Integer leftValue = list.get(index++);
            if (leftValue != null) {
                parent.left = new TreeNode(leftValue);
                queue.offer(parent.left);
            }
            if (index < list.size()) {
                Integer rightValue = list.get(index++);
                if (rightValue != null) {
                    parent.right = new TreeNode(rightValue);
                    queue.offer(parent.right);
                }
            }
        }

        return root;
    }
}
