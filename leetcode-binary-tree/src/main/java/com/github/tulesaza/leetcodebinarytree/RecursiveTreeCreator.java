package com.github.tulesaza.leetcodebinarytree;

import java.util.ArrayList;
import java.util.List;

public class RecursiveTreeCreator implements TreeCreator {
    @Override
    public List<Integer> toList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        addToList(root, result, 0);
        return result;
    }

    private void addToList(TreeNode node, List<Integer> list, int index) {
        if (node == null) {
            list.add(index, null);
            return;
        }
        list.add(index, node.val);
        addToList(node.left, list, 2 * index + 1);
        addToList(node.right, list, 2 * index + 2);
    }

    @Override
    public TreeNode fromList(List<Integer> list) {
        return fromList(list, 0);
    }

    private TreeNode fromList(List<Integer> list, int index) {
        if (index >= list.size() || list.get(index) == null) {
            return null;
        }
        return new TreeNode(list.get(index), fromList(list, 2 * index + 1), fromList(list, 2 * index + 2));
    }
}
