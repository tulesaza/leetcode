package com.github.tulesaza.removingstarsfromastring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "leet**cod*e, lecoe",
            "erase*****, ''"
    })
    void removeStars(String s, String expected) {
        assertEquals(expected, solution.removeStars(s));
    }
}