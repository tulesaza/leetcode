package com.github.tulesaza.reversewordsinastring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "'the sky is blue', 'blue is sky the'",
            "'  hello world  ', 'world hello'",
            "'a good   example', 'example good a'"
    })
    void reverseWords(String s, String reversed) {
        assertEquals(reversed, solution.reverseWords(s));
    }
}