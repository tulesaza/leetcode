package com.github.tulesaza.maximumaveragesubarrayi;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void findMaxAverage(int[] arr, int k, double expected) {
        double result = solution.findMaxAverage(arr, k);
        assertEquals(expected, result);
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 12, -5, -6, 50, 3}, 4, 12.75),
                Arguments.of(new int[]{5}, 1, 5.0)
        );
    }
}