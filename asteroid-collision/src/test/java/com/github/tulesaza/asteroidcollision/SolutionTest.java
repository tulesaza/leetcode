package com.github.tulesaza.asteroidcollision;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void asteroidCollision(int[] input, int[] output) {
        assertArrayEquals(output, solution.asteroidCollision(input));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(arr(5, 10, -5), arr(5, 10)),
                Arguments.of(arr(5, -5), arr()),
                Arguments.of(arr(-5, 5), arr(-5, 5)),
                Arguments.of(arr(10, 2, -5), arr(10)),
                Arguments.of(arr(10, 2, -20), arr(-20)),
                Arguments.of(arr(2, 1, -1, -2), arr()),
                Arguments.of(arr(2, 1, -2, -1), arr(-1))
        );
    }

    static int[] arr(int... a) {
        return a;
    }

}