package com.github.tulesaza.isomorphicstrings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "egg, add, true",
            "foo, bar, false",
            "paper, title, true",
            "babcd, bafdc, false"
    })
    void isIsomorphic(String s, String t, boolean expected) {
        assertEquals(expected, solution.isIsomorphic(s, t));
    }
}