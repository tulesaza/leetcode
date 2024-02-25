package com.github.tulesaza.longestconsecutivesequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void longestConsecutive(int[] arr, int expected) {
        assertEquals(expected, solution.longestConsecutive(arr));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{100, 4, 200, 1, 3, 2}, 4),
                Arguments.of(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9),
                Arguments.of(new int[]{1, 3, 5, 100, 22, 33}, 1),
                Arguments.of(new int[]{1, 3, 5, 100, 22, 33, 6}, 2),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1}, 1)
        );
    }
}