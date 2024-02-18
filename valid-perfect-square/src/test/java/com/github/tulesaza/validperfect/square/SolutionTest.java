package com.github.tulesaza.validperfect.square;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {


    @ParameterizedTest
    @MethodSource("data")
    void linear(int input, boolean isPerfectSquare) {
        var solution = new Solution(Solution.Approach.LINEAR);
        assertEquals(isPerfectSquare, solution.isPerfectSquare(input));

    }

    @ParameterizedTest
    @MethodSource("data")
    void binarySearch(int input, boolean isPerfectSquare) {
        var solution = new Solution(Solution.Approach.BINARY_SEARCH);
        assertEquals(isPerfectSquare, solution.isPerfectSquare(input));
    }

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(0, true),
                Arguments.of(1, true),
                Arguments.of(4, true),
                Arguments.of(5, false),
                Arguments.of(16, true),
                Arguments.of(9, true),
                Arguments.of(961, true),
                Arguments.of(999, false),
                Arguments.of(10000, true),
                Arguments.of(10003, false),
                Arguments.of(100000, false),
                Arguments.of(99856, true),
                Arguments.of(1000000, true),
                Arguments.of(1000001, false),
                Arguments.of(10000000, false),
                Arguments.of(9998244, true),
                Arguments.of(100000000, true),
                Arguments.of(100000003, false),
                Arguments.of(Integer.MAX_VALUE, false),
                Arguments.of(1 << 30, true),
                Arguments.of(2147395600, true)
        );
    }
}