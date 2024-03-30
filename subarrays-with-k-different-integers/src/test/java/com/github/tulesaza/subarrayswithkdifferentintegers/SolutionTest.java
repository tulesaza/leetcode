package com.github.tulesaza.subarrayswithkdifferentintegers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void subarraysWithKDistinct(int[] nums, int k, int expected) {
        assertEquals(expected, solution.subarraysWithKDistinct(nums, k));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1, 2, 3}, 2, 7),
                Arguments.of(new int[]{1, 2, 1, 3, 4}, 3, 3),
                Arguments.of(new int[]{1, 2, 3, 4}, 1, 4),
                Arguments.of(new int[]{1, 2, 3, 4}, 2, 3),
                Arguments.of(new int[]{1, 2, 3, 4}, 5, 0),
                Arguments.of(new int[]{1, 1, 1, 1}, 2, 0)
        );
    }
}