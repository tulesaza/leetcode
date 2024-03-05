package com.github.tulesaza.minimumlengthofstringafterdeletingsimilarends;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "'', 0",
            "a, 1",
            "ab, 2",
            "aba, 1",
            "abba, 0",
            "aabbba, 0",
            "aabbbbbaaaa, 0",
            "aabccabba, 3",
            "cabaabac, 0",
            "bbbbbbbbbbbbbbbbbbb, 0"
    })
    void minimumLength(String s, int expected) {
        assertEquals(expected, solution.minimumLength(s));
    }
}