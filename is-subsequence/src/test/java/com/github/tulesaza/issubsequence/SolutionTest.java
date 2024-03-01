package com.github.tulesaza.issubsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "abc, ahbgdc, true",
            "axc, ahbgdc, false",
            "abc, ffdsfafeggegegegecccbfefewfc, true",
            "abc, abc, true",
            "aaaaaa, bbaaaa, false"
    })
    void isSubsequence(String s, String t, boolean expected) {
        assertEquals(expected, solution.isSubsequence(s, t));
    }
}