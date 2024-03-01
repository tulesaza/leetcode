package com.github.tulesaza.mergestringsalternately;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "abc, pqr, apbqcr",
            "ab, pqrs, apbqrs",
            "abcd, pq, apbqcd"

    })
    void mergeAlternately(String s1, String s2, String expected) {
        assertEquals(expected, solution.mergeAlternately(s1, s2));
    }
}