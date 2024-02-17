package com.tulesaza.maximumsubarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void maxSubArray(int[] arr, int maxSum) {
        assertEquals(maxSum, solution.maxSubArray(arr));
    }

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{5, 4, -1, 7, 8}, 23),
                Arguments.of(new int[]{-1, -3}, -1)
        );
    }
}