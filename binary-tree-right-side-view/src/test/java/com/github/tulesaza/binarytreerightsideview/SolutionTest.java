package com.github.tulesaza.binarytreerightsideview;

import com.github.tulesaza.leetcodebinarytree.LeetcodeTreeCreator;
import com.github.tulesaza.leetcodebinarytree.TreeCreator;
import com.github.tulesaza.leetcodebinarytree.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();
    TreeCreator treeCreator = new LeetcodeTreeCreator();

    @ParameterizedTest
    @MethodSource("data")
    void rightSideViewIterative(List<Integer> tree, List<Integer> expectedRightSideView) {
        TreeNode root = treeCreator.fromList(tree);
        List<Integer> result = solution.rightSideViewIterative(root);
        assertThat(result).isEqualTo(expectedRightSideView);
    }

    @ParameterizedTest
    @MethodSource("data")
    void rightSideViewRecursive(List<Integer> tree, List<Integer> expectedRightSideView) {
        TreeNode root = treeCreator.fromList(tree);
        List<Integer> result = solution.rightSideViewRecursive(root);
        assertThat(result).isEqualTo(expectedRightSideView);
    }


    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(list(1, 2, 3, null, 5, null, 4), List.of(1, 3, 4)),
                Arguments.of(list(1, null, 3), List.of(1, 3)),
                Arguments.of(list(), List.of()),
                Arguments.of(list(1, 2), List.of(1, 2)),
                Arguments.of(list(1, 2, 3, 4), List.of(1, 3, 4))
        );
    }

    static List<Integer> list(Integer... a) {
        return Arrays.asList(a);
    }
}