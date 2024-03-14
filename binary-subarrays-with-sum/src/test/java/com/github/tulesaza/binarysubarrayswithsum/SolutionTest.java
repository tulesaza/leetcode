package com.github.tulesaza.binarysubarrayswithsum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void numSubarraysWithSum(int[] array, int goal, int expectedCount) {

        assertEquals(expectedCount, solution.numSubarraysWithSum(array, goal));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 1, 0, 1}, 2, 4),
                Arguments.of(new int[]{0, 0, 0, 0, 0}, 0, 15)
        );
    }
}