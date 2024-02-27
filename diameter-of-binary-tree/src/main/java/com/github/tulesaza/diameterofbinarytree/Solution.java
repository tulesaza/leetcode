package com.github.tulesaza.diameterofbinarytree;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        AtomicInteger diameter = new AtomicInteger(0);
        dfs(root, diameter);
        return diameter.get();
    }

    private int dfs(TreeNode node, AtomicInteger diameter) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left, diameter);
        int right = dfs(node.right, diameter);
        diameter.set(Math.max(diameter.get(), left + right));
        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTreeIterative(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        Map<TreeNode, Integer> maxDepths = new HashMap<>();
        int diameter = 0;
        stack.push(root);
        while (!stack.isEmpty()) {
            var current = stack.pop();
            if (visited.contains(current)) {
                int leftDepth = Optional.ofNullable(current.left).map(maxDepths::get).orElse(0);
                int rightDepth = Optional.ofNullable(current.right).map(maxDepths::get).orElse(0);
                diameter = Math.max(diameter , leftDepth + rightDepth);
                maxDepths.put(current, 1 + Math.max(leftDepth, rightDepth));

            } else {
                visited.add(current);
                stack.push(current);
                Optional.ofNullable(current.left).ifPresent(stack::push);
                Optional.ofNullable(current.right).ifPresent(stack::push);
            }
        }
        return diameter;
    }

    /**
     * Definition for a binary tree node.
     **/
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
}
