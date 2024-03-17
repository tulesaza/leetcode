package com.github.tulesaza.insertinterval;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void insert1(int[][] intervals, int[] interval, int[][] expected) {
        var result = solution.insert1(intervals, interval);
        assertArrayEquals(expected, result, "expected %s but was %s".formatted(
                Arrays.deepToString(expected), Arrays.deepToString(result)));
    }

    @ParameterizedTest
    @MethodSource("data")
    void insert2(int[][] intervals, int[] interval, int[][] expected) {
        var result = solution.insert2(intervals, interval);
        assertArrayEquals(expected, result, "expected %s but was %s".formatted(
                Arrays.deepToString(expected), Arrays.deepToString(result)));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(intervals(), interval(2, 5), intervals(interval(2, 5))),
                Arguments.of(intervals(interval(1, 5)), interval(2, 3), intervals(interval(1, 5))),
                Arguments.of(intervals(interval(1, 5)), interval(0, 1), intervals(interval(0, 5))),
                Arguments.of(intervals(interval(1, 3), interval(4, 5), interval(7, 8), interval(9, 10)),
                             interval(2, 9), intervals(interval(1, 10))),
                Arguments.of(intervals(interval(1, 3), interval(4, 5), interval(10, 20)), interval(6, 8),
                             intervals(interval(1, 3), interval(4, 5), interval(6, 8), interval(10, 20)))
        );
    }

    static int[] interval(int s, int e) {
        return new int[]{s, e};
    }

    static int[][] intervals(int[]... a) {
        return a;
    }
}