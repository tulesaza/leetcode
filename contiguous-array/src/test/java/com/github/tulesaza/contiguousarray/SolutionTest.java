package com.github.tulesaza.contiguousarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void findMaxLength(int[] nums, int expectedMaxLength) {
        assertEquals(expectedMaxLength, solution.findMaxLength(nums));
    }


    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 0, 1}, 2),
                Arguments.of(new int[]{0, 0, 0, 1, 1}, 4),
                Arguments.of(new int[]{0, 1, 0, 1}, 4),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{0, 1}, 2)
        );
    }
}