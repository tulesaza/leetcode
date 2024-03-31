package com.github.tulesaza.countsubarrayswithfixedbounds;

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
    void countSubarrays(int[] nums, int minK, int maxK, long expected) {
        assertEquals(expected, solution.countSubarrays(nums, minK, maxK));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 2, 7, 5}, 1, 5, 2L),
                Arguments.of(new int[]{1, 1, 1, 1}, 2, 10, 0),
                Arguments.of(new int[]{9, 10, 11, 12}, 20, 30, 0),
                Arguments.of(new int[]{1, 1, 1, 1}, 1, 1, 10),
                Arguments.of(IntStream.range(0, (int) 1e5).map(a -> 5).toArray(), 5, 5, 5000050000L),
                Arguments.of(new int[]{5, 6}, 5, 6, 1)
        );
    }
}