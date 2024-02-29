package com.github.tulesaza.evenoddtree;


import com.github.tulesaza.leetcodebinarytree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class Solution {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 1000000;

    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean oddLevel = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int previousValue = oddLevel ? MIN_VALUE - 1 : MAX_VALUE + 1;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // level and value oddity are the same
                if ((node.val & 1) == 1 ^ oddLevel
                        // descending order on odd level and ascending on even level
                        || ((oddLevel && node.val <= previousValue) || (!oddLevel && node.val >= previousValue))) {
                    return false;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                previousValue = node.val;
            }
            oddLevel = !oddLevel;
        }
        return true;
    }
}
