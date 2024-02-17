package com.tulesaza.addbinary;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "11, 1, 100",
            "1010, 1011, 10101"
    })
    void addBinary(String a, String b, String expectedSum) {
        assertEquals(expectedSum, solution.addBinary(a, b));
    }
}