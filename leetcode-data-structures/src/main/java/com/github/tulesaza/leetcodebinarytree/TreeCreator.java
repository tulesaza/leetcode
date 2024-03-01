package com.github.tulesaza.leetcodebinarytree;

import java.util.List;

public interface TreeCreator {

    List<Integer> toList(TreeNode root);

    TreeNode fromList (List<Integer> list);
}
