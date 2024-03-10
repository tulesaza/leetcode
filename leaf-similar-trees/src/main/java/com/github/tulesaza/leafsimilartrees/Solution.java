package com.github.tulesaza.leafsimilartrees;

import com.github.tulesaza.leetcodebinarytree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    // Time O(n+m), space O(logN +logM + leafM + leafN)) ~ O(n+m)
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<>();
        List<Integer> leafs2 = new ArrayList<>();
        dfs(root1, leafs1);
        dfs(root2, leafs2);
        return leafs1.equals(leafs2);
    }

    private void dfs(TreeNode root, List<Integer> leafs) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leafs.add(root.val);
            return;
        }
        dfs(root.left, leafs);
        dfs(root.right, leafs);
    }

    // Time O(n+m), space O(logN +logM + leafM + leafN)) ~ O(n+m)
    public boolean leafSimilarIterative(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = iterativeDfs(root1);
        List<Integer> leafs2 = iterativeDfs(root2);
        return leafs1.equals(leafs2);
    }

    private List<Integer> iterativeDfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.left == null && current.right == null) {
                result.add(current.val);
                continue;
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return result;
    }
}