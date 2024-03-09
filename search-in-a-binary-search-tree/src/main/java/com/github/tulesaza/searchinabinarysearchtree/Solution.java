package com.github.tulesaza.searchinabinarysearchtree;

import com.github.tulesaza.leetcodebinarytree.TreeNode;

class Solution {
    public TreeNode searchBSTRecursive(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        return root.val > val ? searchBSTRecursive(root.left, val) : searchBSTRecursive(root.right, val);
    }

    public TreeNode searchBSTIterative(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) return root;
            root = root.val > val ? root.left : root.right;
        }

        return null;
    }
}