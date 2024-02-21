package com.github.tulesaza.trappingrainwater;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void trap(int[] heights, int water) {
        assertEquals(water, solution.trap(heights));
    }

    @ParameterizedTest
    @MethodSource("data")
    void trapCoolHackerStyle(int[] heights, int water) {
        assertEquals(water, solution.trapCoolHackerStyle(heights));
    }

    private static Stream<Arguments> data() {
        return Stream.of(Arguments.of(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
                         Arguments.of(new int[]{4, 2, 0, 3, 2, 5}, 9), Arguments.of(new int[]{0, 1, 1, 1, 2, 3}, 0),
                         Arguments.of(new int[]{4, 2, 3}, 1), Arguments.of(new int[]{5, 4, 1, 2}, 1));
    }


}