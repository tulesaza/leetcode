package com.github.tulesaza.validpalindrome;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "'A man, a plan, a canal: Panama', true",
            "'race a car', false",
            "' ', true",
            "'', true",
            "aba, true",
            "abba, true",
            "a, true",
            "0P, false",
            "',; W;:GlG:;l ;,', false"
    })
    void isPalindrome(String s, boolean palindrome) {
        assertEquals(palindrome, solution.isPalindrome(s));
    }
}