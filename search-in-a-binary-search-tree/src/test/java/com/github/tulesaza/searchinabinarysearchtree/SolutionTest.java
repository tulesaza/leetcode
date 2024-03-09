package com.github.tulesaza.searchinabinarysearchtree;

import com.github.tulesaza.leetcodebinarytree.LeetcodeTreeCreator;
import com.github.tulesaza.leetcodebinarytree.TreeCreator;
import com.github.tulesaza.leetcodebinarytree.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    final TreeCreator treeCreator = new LeetcodeTreeCreator();
    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void searchBSTRecursive(List<Integer> input, int value, List<Integer> output) {
        TreeNode root = treeCreator.fromList(input);
        TreeNode found = solution.searchBSTRecursive(root, value);
        assertThat(treeCreator.toList(found)).isEqualTo(output);
    }

    @ParameterizedTest
    @MethodSource("data")
    void searchBSTIterative(List<Integer> input, int value, List<Integer> output) {
        TreeNode root = treeCreator.fromList(input);
        TreeNode found = solution.searchBSTIterative(root, value);
        assertThat(treeCreator.toList(found)).isEqualTo(output);
    }


    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(List.of(4, 2, 7, 1, 3), 2, List.of(2, 1, 3)),
                Arguments.of(List.of(4, 2, 7, 1, 3), 5, Collections.emptyList())
        );
    }


}