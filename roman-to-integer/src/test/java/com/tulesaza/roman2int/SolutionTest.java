package com.tulesaza.roman2int;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "III, 3",
            "LVIII, 58",
            "MCMXCIV, 1994",
            "IX, 9"
    })
    void romanToInt(String input, int expected) {
        assertEquals(expected, solution.romanToInt(input));
    }
}