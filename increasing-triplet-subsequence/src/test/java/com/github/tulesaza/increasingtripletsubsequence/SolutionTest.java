package com.github.tulesaza.increasingtripletsubsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void increasingTriplet(int[] nums, boolean contains) {
        assertEquals(contains, solution.increasingTriplet(nums));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, true),
                Arguments.of(new int[]{4, 3, 2, 1}, false),
                Arguments.of(new int[]{231, 2, 32432, 3, 5454}, true)
        );
    }
}