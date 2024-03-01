package com.github.tulesaza.countingbits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void countBits(int n, int[] expected) {
        assertArrayEquals(expected, solution.countBits(n));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(5, new int[]{0, 1, 1, 2, 1, 2}),
                Arguments.of(2, new int[]{0, 1, 1})
        );
    }

}