package com.github.tulesaza.findbottomlefttreevalue;


import com.github.tulesaza.leetcodebinarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;


class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int bottomLeftValue = 0;
        while (!queue.isEmpty()) {
            bottomLeftValue = queue.peek().val;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return bottomLeftValue;
    }
}
