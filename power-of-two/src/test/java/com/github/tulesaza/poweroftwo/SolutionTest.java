package com.github.tulesaza.poweroftwo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "7, false",
            "8, true",
            "20, false",
            "1, true",
            "16, true",
            "1073741824, true",
            "-16, false",
            "-1, false"
    })
    void isPowerOfTwo(int n, boolean expected) {
        assertEquals(expected, solution.isPowerOfTwo1(n));
        assertEquals(expected, solution.isPowerOfTwo2(n));
    }

}