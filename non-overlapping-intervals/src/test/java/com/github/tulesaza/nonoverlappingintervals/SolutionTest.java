package com.github.tulesaza.nonoverlappingintervals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void eraseOverlapIntervals(int[][] intervals, int removed) {
        assertEquals(removed, solution.eraseOverlapIntervals(intervals));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[][]{interval(1, 2), interval(2, 3), interval(3, 4), interval(1, 3)}, 1),
                Arguments.of(new int[][]{interval(1, 2), interval(1, 2), interval(1, 2), interval(1, 2)}, 3),
                Arguments.of(new int[][]{interval(1, 5), interval(4, 5), interval(3, 4)}, 1),
                Arguments.of(new int[][]{interval(1, 3), interval(5, 10)}, 0)

        );
    }

    static int[] interval(int s, int e) {
        return new int[]{s, e};
    }

}