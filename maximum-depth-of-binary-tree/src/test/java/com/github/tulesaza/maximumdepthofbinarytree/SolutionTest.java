package com.github.tulesaza.maximumdepthofbinarytree;

import com.github.tulesaza.leetcodebinarytree.LeetcodeTreeCreator;
import com.github.tulesaza.leetcodebinarytree.TreeCreator;
import com.github.tulesaza.leetcodebinarytree.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();
    final TreeCreator treeCreator = new LeetcodeTreeCreator();

    @ParameterizedTest
    @MethodSource("data")
    void maxDepthRecursive(List<Integer> list, int expectedMaxDepth) {
        TreeNode root = treeCreator.fromList(list);
        assertEquals(expectedMaxDepth, solution.maxDepthRecursive(root));
    }

    @ParameterizedTest
    @MethodSource("data")
    void maxDepthIterative(List<Integer> list, int expectedMaxDepth) {
        TreeNode root = treeCreator.fromList(list);
        assertEquals(expectedMaxDepth, solution.maxDepthIterative(root));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(list(3, 9, 20, null, null, 15, 7), 3),
                Arguments.of(Collections.emptyList(), 0),
                Arguments.of(list(1, null, 2), 2)
        );
    }

    static List<Integer> list(Integer... args) {
        return Arrays.asList(args);
    }
}