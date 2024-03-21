package com.github.tulesaza.successfulpairsofspellsandpotions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void successfulPairs(int[] spells, int[] potions, long success, int[] expected) {
        long a = (long) 10e10;
        assertArrayEquals(expected, solution.successfulPairs(spells, potions, success));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(arr(5, 1, 3), arr(1, 2, 3, 4, 5), 7, arr(4, 0, 3)),
                Arguments.of(arr(3, 1, 2), arr(8, 7, 8), 16, arr(3, 0, 2)),
                Arguments.of(arr(10000, 10000, 100000), arr(5000, 2000, 100000), (long) 1e10, arr(0, 0, 1)),
                Arguments.of(arr(5, 6, 7), arr(1, 2, 3, 4, 5, 6, 7), 25, arr(3, 3, 4))
        );
    }

    static int[] arr(int... a) {
        return a;
    }
}