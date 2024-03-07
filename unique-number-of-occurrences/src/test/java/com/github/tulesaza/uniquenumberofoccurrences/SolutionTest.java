package com.github.tulesaza.uniquenumberofoccurrences;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void uniqueOccurrences(int[] arr, boolean expected) {
        assertEquals(expected, solution.uniqueOccurrences(arr));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, false),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3}, true)
        );
    }
}