package com.github.tulesaza.evenoddtree;

import com.github.tulesaza.leetcodebinarytree.LeetcodeTreeCreator;
import com.github.tulesaza.leetcodebinarytree.TreeCreator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final TreeCreator creator = new LeetcodeTreeCreator();
    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void isEvenOddTree(List<Integer> tree, boolean expected) {
        assertEquals(expected, solution.isEvenOddTree(creator.fromList(tree)));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(list(1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2), true),
                Arguments.of(list(5, 4, 2, 3, 3, 7), false),
                Arguments.of(list(5, 9, 1, 3, 5, 7), false)
        );
    }

    static List<Integer> list(Integer... nums) {
        return Arrays.asList(nums);
    }
}