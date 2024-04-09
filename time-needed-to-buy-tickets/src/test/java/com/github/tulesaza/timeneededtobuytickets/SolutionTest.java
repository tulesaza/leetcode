package com.github.tulesaza.timeneededtobuytickets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 2}, 2, 6),
                Arguments.of(new int[]{1, 5, 5, 5}, 0, 1),
                Arguments.of(new int[]{1, 2, 1, 3, 5}, 2, 3),
                Arguments.of(new int[]{5, 1, 1, 1}, 0, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void timeRequiredToBuy(int[] tickets, int k, int expected) {
        assertEquals(expected, solution.timeRequiredToBuy(tickets, k));
    }
}