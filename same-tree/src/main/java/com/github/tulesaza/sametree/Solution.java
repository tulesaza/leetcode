package com.github.tulesaza.sametree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// No test class, tested by leetcode itself and write tests is more time-consuming than write solution
class Solution {
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right);

    }

    public boolean isSameTreeBfs(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        Deque<TreeNode> queueP = new ArrayDeque<>();
        Deque<TreeNode> queueQ = new ArrayDeque<>();
        queueP.offer(p);
        queueQ.offer(q);
        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            p = queueP.poll();
            q = queueQ.poll();
            if (p.val != q.val) {
                return false;
            }
            TreeNode leftP = p.left, rightP = p.right;
            TreeNode leftQ = q.left, rightQ = q.right;
            if (leftP == null ^ leftQ == null) { // a XOR b = (!a && b) || (a && !b) e.g when leftP and leftQ are different
                return false;
            }
            if (rightP == null ^ rightQ == null) {
                return false;
            }
            if (leftP != null) {
                queueP.offer(leftP);
                queueQ.offer(leftQ);
            }
            if (rightP != null) {
                queueP.offer(rightP);
                queueQ.offer(rightQ);
            }
        }
        return true;
    }

    public static class TreeNode {
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
