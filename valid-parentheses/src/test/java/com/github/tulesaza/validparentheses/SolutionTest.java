package com.github.tulesaza.validparentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "(), true",
            "[]{}(), true",
            "(())[, false"
    })
    void isValid(String s, boolean expected) {
        assertEquals(expected, solution.isValid(s));
    }
}