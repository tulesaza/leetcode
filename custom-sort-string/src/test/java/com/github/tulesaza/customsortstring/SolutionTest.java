package com.github.tulesaza.customsortstring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void customSortString1(String order, String s, String expectedPrefix) {
        String result = solution.customSortString1(order, s);
        assertEquals(s.length(), result.length());
        assertTrue(result.startsWith(expectedPrefix));
    }

    @ParameterizedTest
    @MethodSource("data")
    void customSortString2(String order, String s, String expectedPrefix) {
        String result = solution.customSortString2(order, s);
        assertEquals(s.length(), result.length());
        assertTrue(result.startsWith(expectedPrefix));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("cba", "abcd", "cba"),
                Arguments.of("bcafg", "abcd", "bca")
        );
    }
}