package com.github.tulesaza.squaresofasortedarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void sortedSquares(int[] input, int[] output) {
        assertArrayEquals(output, solution.sortedSquares(input));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{-4, -1, 0, 3, 10}, new int[]{0, 1, 9, 16, 100}),
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{-1}, new int[]{1}),
                Arguments.of(new int[]{-7, -3, 2, 3, 11}, new int[]{4, 9, 9, 49, 121})
        );
    }
}