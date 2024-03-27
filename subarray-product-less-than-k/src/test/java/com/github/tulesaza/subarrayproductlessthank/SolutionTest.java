package com.github.tulesaza.subarrayproductlessthank;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void numSubarrayProductLessThanK(int[] nums, int k, int expected) {
        assertEquals(expected, solution.numSubarrayProductLessThanK(nums, k));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{10, 5, 2, 6}, 100, 8),
                Arguments.of(new int[]{1, 2, 3}, 0, 0),
                Arguments.of(new int[]{1, 1, 1}, 2, 6)
        );
    }
}