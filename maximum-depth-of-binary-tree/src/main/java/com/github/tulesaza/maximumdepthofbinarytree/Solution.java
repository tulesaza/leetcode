package com.github.tulesaza.maximumdepthofbinarytree;

import com.github.tulesaza.leetcodebinarytree.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

class Solution {
    // O(N) time, O(logN) - space , where N is number of nodes, since max N = 10^4, should be good, otherwise
    // iterative is preferable
    public int maxDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));
    }

    // O(2N) time, O(N) - space,
    public int maxDepthIterative(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> stack = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        Map<TreeNode, Integer> maxPerNode = new HashMap<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            if (visited.contains(current)) {
                int left = maxPerNode.getOrDefault(current.left, 0);
                int right = maxPerNode.getOrDefault(current.right, 0);
                maxPerNode.put(current, Math.max(left, right) + 1);
                stack.pop();
                continue;
            }
            visited.add(current);

            if (current.left != null) {
                stack.push(current.left);
            }

            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return maxPerNode.get(root);

    }
}