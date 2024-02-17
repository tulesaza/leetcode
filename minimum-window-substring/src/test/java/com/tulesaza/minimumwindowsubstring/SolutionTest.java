package com.tulesaza.minimumwindowsubstring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "ADOBECODEBANC, ABC, BANC",
            "a, a, a",
            "a, aa, ''"
    })
    void minWindow(String s, String t, String window) {
        assertEquals(window, solution.minWindow(s, t));
    }
}