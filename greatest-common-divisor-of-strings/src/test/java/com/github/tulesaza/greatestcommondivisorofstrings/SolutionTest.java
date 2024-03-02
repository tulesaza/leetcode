package com.github.tulesaza.greatestcommondivisorofstrings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "ABCABC, ABC, ABC",
            "ABABAB, ABAB, AB",
            "LEET, CODE, ''",
            "AAAAA, AAA, A",
            "ABCABCABCABCABC, ABCABC, ABC"
    })
    void gcdOfStrings(String s1, String s2, String gcd) {
        assertEquals(gcd, solution.gcdOfStrings(s1, s2));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "ABCABC, ABC, ABC",
            "ABABAB, ABAB, AB",
            "LEET, CODE, ''",
            "AAAAA, AAA, A",
            "ABCABCABCABCABC, ABCABC, ABC"
    })
    void gcdOfStrings2(String s1, String s2, String gcd) {
        assertEquals(gcd, solution.gcdOfStrings2(s1, s2));
    }

}