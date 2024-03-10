package com.github.tulesaza.determineiftwostringsareclose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "abc, bca, true",
            "abb, baa, true",
            "cabbba, abbccc, true",
            "a,b,false",
            "a,aa,false",
            "a,a, true"
    })
    void closeStrings(String s1, String s2, boolean close) {
        assertEquals(close, solution.closeStrings(s1, s2));
    }
}