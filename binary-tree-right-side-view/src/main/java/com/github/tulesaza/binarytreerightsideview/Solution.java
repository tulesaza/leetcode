package com.github.tulesaza.binarytreerightsideview;

import com.github.tulesaza.leetcodebinarytree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<Integer> rightSideViewIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            list.add(queue.peek().val);
            for (int i = queue.size(); i > 0; i--) {
                TreeNode current = queue.poll();
                if (current.right != null) {
                    queue.offer(current.right);
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
            }
        }
        return list;
    }


    public List<Integer> rightSideViewRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    private void dfs(TreeNode node, List<Integer> list, int depth) {
        if (node == null) {
            return;
        }
        if (depth == list.size()) {
            list.add(node.val);
        }
        dfs(node.right, list, depth + 1);
        dfs(node.left, list, depth + 1);
    }
}