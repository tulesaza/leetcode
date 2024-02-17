package com.tulesaza.palindromenumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "-100, false",
            "33, true",
            "3, true",
            "24234273, false",
            "4312134, true"
    })
    void isPalindrome(int input, boolean expected) {
        assertEquals(expected, solution.isPalindrome(input));
    }
}