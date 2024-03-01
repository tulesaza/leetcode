package com.github.tulesaza.maximumoddbinarynumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "100, 001",
            "110, 101",
            "0101, 1001",
            "0111, 1101",
            "1011, 1101"
    })
    void maximumOddBinaryNumber(String binary, String expected) {
        assertEquals(expected, solution.maximumOddBinaryNumber(binary));
    }
}