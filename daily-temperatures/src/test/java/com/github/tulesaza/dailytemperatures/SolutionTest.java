package com.github.tulesaza.dailytemperatures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void dailyTemperatures(int[] temperatures, int[] days) {
        assertArrayEquals(days, solution.dailyTemperatures(temperatures));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(arr(73, 74, 75, 71, 69, 72, 76, 73), arr(1, 1, 4, 2, 1, 1, 0, 0)),
                Arguments.of(arr(30, 40, 50, 60), arr(1, 1, 1, 0)),
                Arguments.of(arr(30, 60, 90), arr(1, 1, 0)),
                Arguments.of(arr(1), arr(0))
        );
    }

    static int[] arr(int... args) {
        return args;
    }
}