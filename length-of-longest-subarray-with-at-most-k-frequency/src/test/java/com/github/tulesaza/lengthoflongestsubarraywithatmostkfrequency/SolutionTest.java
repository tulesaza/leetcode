package com.github.tulesaza.lengthoflongestsubarraywithatmostkfrequency;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void maxSubarrayLength(int[] nums, int k, int expected) {
        assertEquals(expected, solution.maxSubarrayLength(nums, k));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2, 6),
                Arguments.of(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1, 2),
                Arguments.of(new int[]{5, 5, 5, 5, 5, 5, 5, 5}, 4, 4)
        );
    }
}