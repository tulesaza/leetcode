package com.github.tulesaza.leetcodebinarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class IterativeTreeCreator implements TreeCreator {
    @Override
    public TreeNode fromList(List<Integer> list) {
        Deque<Object[]> queue = new LinkedList<>();
        TreeNode root = new TreeNode(list.getFirst());
        queue.offer(new Object[]{root, new int[]{1, 2}});
        while (!queue.isEmpty()) {
            Object[] relation = queue.poll();
            TreeNode parent = (TreeNode) relation[0];
            int[] indexes = (int[]) relation[1];
            int left = indexes[0], right = indexes[1];

            if (left < list.size() && parent != null) {
                TreeNode leftChild = list.get(left) != null ? new TreeNode(list.get(left)) : null;
                parent.left = leftChild;
                if (leftChild != null) {
                    queue.offer(new Object[]{leftChild, new int[]{2 * left + 1, 2 * left + 2}});
                }
            }
            if (right < list.size() && parent != null) {
                TreeNode rightChild = list.get(right) != null ? new TreeNode(list.get(right)) : null;
                parent.right = rightChild;
                if (rightChild != null) {
                    queue.offer(new Object[]{rightChild, new int[]{2 * right + 1, 2 * right + 2}});
                }
            }
        }

        return root;
    }

    @Override
    public List<Integer> toList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<Optional<TreeNode>> queue = new ArrayDeque<>();
        queue.offer(Optional.of(root));
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
}
