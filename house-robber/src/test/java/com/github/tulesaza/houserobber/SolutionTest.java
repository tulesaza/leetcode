package com.github.tulesaza.houserobber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void rob(int[] houses, int max) {
        assertEquals(max, solution.rob(houses));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, 4),
                Arguments.of(new int[]{2, 7, 9, 3, 1}, 12),
                Arguments.of(new int[]{2, 1, 0, 4}, 6),
                Arguments.of(new int[]{2, 0, 0, 4, 10}, 12),
                Arguments.of(new int[]{1, 2}, 2),
                Arguments.of(new int[]{1}, 1)
        );
    }

}