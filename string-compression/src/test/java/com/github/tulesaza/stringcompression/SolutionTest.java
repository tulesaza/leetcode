package com.github.tulesaza.stringcompression;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();
    @ParameterizedTest
    @CsvSource(value = {
            "aabbcc, 6, a2b2c2",
            "a, 1, a",
            "abbbbbbbbbbbb, 4, ab12",
            "abc, 3, abc",
            "aaavgggg, 5, a3vg4"
    })
    void compress(String input, int expectedLength, String expectedOutput) {
        char [] arr = input.toCharArray();
        int result = solution.compress(arr);
        assertEquals(expectedLength, result);
        for (int i = 0; i < expectedLength; i++) {
            assertEquals(expectedOutput.charAt(i), arr[i]);
        }
    }

}