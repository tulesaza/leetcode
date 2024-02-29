package com.github.tulesaza.movezeroes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void moveZeroes(int[] input, int[] output) {
        solution.moveZeroes(input);
        assertArrayEquals(output, input);
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 2, 3}, new int[]{1, 2, 3, 0, 0}),
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{1, 3, 22}, new int[]{1, 3, 22})
        );
    }
}