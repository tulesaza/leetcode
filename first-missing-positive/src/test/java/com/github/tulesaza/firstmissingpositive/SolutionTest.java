package com.github.tulesaza.firstmissingpositive;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void firstMissingPositive(int[] nums, int expected) {
        assertEquals(expected, solution.firstMissingPositive(nums));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, -3, 4}, 2),
                Arguments.of(new int[]{1, 2, 0}, 3),
                Arguments.of(new int[]{1, 1, 1}, 2),
                Arguments.of(new int[]{8, 10, 11, 12, 1, 2}, 3),
                Arguments.of(new int[]{8, 10, 11, 12}, 1),
                Arguments.of(new int[]{2}, 1),
                Arguments.of(new int[]{0}, 1),
                Arguments.of(IntStream.rangeClosed(1, (int) 1e5).toArray(), (int) 1e5 + 1),
                Arguments.of(IntStream.rangeClosed(Integer.MAX_VALUE - (int) 1e5, Integer.MAX_VALUE).toArray(), 1)
        );
    }
}