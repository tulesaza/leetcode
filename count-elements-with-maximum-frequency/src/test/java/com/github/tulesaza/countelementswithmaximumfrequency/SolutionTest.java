package com.github.tulesaza.countelementswithmaximumfrequency;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void maxFrequencyElements(int[] nums, int expected) {
        assertEquals(expected, solution.maxFrequencyElements(nums));
    }


    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 5),
                Arguments.of(new int[]{1, 2, 3, 4, 2, 5, 1}, 4)
        );
    }
}