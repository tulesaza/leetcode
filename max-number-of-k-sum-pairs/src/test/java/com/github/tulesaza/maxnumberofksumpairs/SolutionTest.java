package com.github.tulesaza.maxnumberofksumpairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void maxOperations1(int[] nums, int k, int expected) {
        assertEquals(expected, solution.maxOperations1(nums, k));
    }

    @ParameterizedTest
    @MethodSource("data")
    void maxOperations2(int[] nums, int k, int expected) {
        assertEquals(expected, solution.maxOperations2(nums, k));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 5, 2),
                Arguments.of(new int[]{3, 1, 3, 4, 3}, 6, 1),
                Arguments.of(new int[]{1, 2, 3,}, 6, 0),
                Arguments.of(new int[]{1}, 1, 0)
        );
    }
}