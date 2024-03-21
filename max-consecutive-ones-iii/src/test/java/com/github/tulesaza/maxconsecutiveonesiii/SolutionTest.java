package com.github.tulesaza.maxconsecutiveonesiii;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void longestOnes(int[] nums, int k, int expected) {
        assertEquals(expected, solution.longestOnes(nums, k));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2, 6),
                Arguments.of(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3, 10)
        );
    }
}