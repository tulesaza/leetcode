package com.github.tulesaza.equalrowandcolumnpairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void equalPairs(int[][] matrix, int equalPairs) {
        assertEquals(equalPairs, solution.equalPairs(matrix));
    }


    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(grid(row(1, 2, 3), row(1, 2, 3), row(1, 2, 3)), 0),
                Arguments.of(grid(row(1, 2, 3), row(2, 2, 3), row(3, 2, 3)), 1),
                Arguments.of(grid(row(3, 1, 2, 2), row(1, 4, 4, 5), row(2, 4, 2, 2), row(2, 4, 2, 2)), 3),
                Arguments.of(grid(row(3, 2, 1), row(1, 7, 6), row(2, 7, 7)), 1),
                Arguments.of(grid(row(11, 1), row(1, 11)), 2)
        );
    }

    static int[] row(int... a) {
        return a;
    }

    static int[][] grid(int[]... a) {
        return a;
    }
}