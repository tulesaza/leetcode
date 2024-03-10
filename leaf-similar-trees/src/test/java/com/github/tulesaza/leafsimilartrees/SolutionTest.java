package com.github.tulesaza.leafsimilartrees;

import com.github.tulesaza.leetcodebinarytree.LeetcodeTreeCreator;
import com.github.tulesaza.leetcodebinarytree.TreeCreator;
import com.github.tulesaza.leetcodebinarytree.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final TreeCreator treeCreator = new LeetcodeTreeCreator();
    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void leafSimilar(List<Integer> list1, List<Integer> list2, boolean expected) {
        TreeNode r1 = treeCreator.fromList(list1);
        TreeNode r2 = treeCreator.fromList(list2);
        assertEquals(expected, solution.leafSimilar(r1, r2));
    }

    @ParameterizedTest
    @MethodSource("data")
    void leafSimilarIterative(List<Integer> list1, List<Integer> list2, boolean expected) {
        TreeNode r1 = treeCreator.fromList(list1);
        TreeNode r2 = treeCreator.fromList(list2);
        assertEquals(expected, solution.leafSimilarIterative(r1, r2));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(list(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4),
                             list(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8), true),
                Arguments.of(list(1, 2, 3), list(1, 3, 2), false)
        );
    }

    static List<Integer> list(Integer... a) {
        return Arrays.asList(a);
    }
}