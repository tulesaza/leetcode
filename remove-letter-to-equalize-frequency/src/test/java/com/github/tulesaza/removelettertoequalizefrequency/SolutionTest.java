package com.github.tulesaza.removelettertoequalizefrequency;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "abcc, true",
            "aabb, false",
            "a, true",
            "aaabc, false"
    })
    void equalFrequency(String s, boolean expected) {

        assertEquals(expected, solution.equalFrequency(s));
    }
}