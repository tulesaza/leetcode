package com.tulesaza.longestcommonprefix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "flower|flow|fluent, fl",
            "aza|mat, ''",
            "longest|longess|longeee, longe"
    })
    void longestCommonPrefix(String input, String expected) {
        var parsed = input.split("\\|");
        assertEquals(expected, solution.longestCommonPrefix(parsed));
    }
}