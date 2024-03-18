package com.github.tulesaza.minimumnumberofarrowstoburstballoons;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void findMinArrowShots(int[][] points, int expected) {
        assertEquals(expected, solution.findMinArrowShots(points));
    }


    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(ps(p(10, 16), p(2, 8), p(1, 6), p(7, 12)), 2),
                Arguments.of(ps(p(1, 2), p(3, 4), p(5, 6), p(7, 10)), 4),
                Arguments.of(ps(p(1, 2), p(2, 3), p(3, 4), p(4, 5)), 2),
                Arguments.of(ps(p(1, 2), p(1, 2)), 1),
                Arguments.of(ps(p(3, 9), p(7, 12), p(3, 8), p(6, 8), p(9, 10),
                                p(2, 9), p(0, 9), p(3, 9), p(0, 6), p(2, 8)), 2)
        );
    }

    static int[] p(int s, int e) {
        return new int[]{s, e};
    }

    static int[][] ps(int[]... p) {
        return p;
    }
}