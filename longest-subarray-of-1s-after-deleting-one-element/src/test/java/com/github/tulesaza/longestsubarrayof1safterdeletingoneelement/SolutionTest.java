package com.github.tulesaza.longestsubarrayof1safterdeletingoneelement;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void longestSubarray(int[] array, int longestWindow) {
        assertEquals(longestWindow, solution.longestSubarray(array));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 0, 1}, 3),
                Arguments.of(new int[]{1, 1, 1, 1}, 3),
                Arguments.of(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}, 5),
                Arguments.of(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1}, 4),
                Arguments.of(new int[]{0, 0, 0}, 0),
                Arguments.of(new int[]{0, 1, 0}, 1),
                Arguments.of(new int[]{0}, 0)
        );
    }
}