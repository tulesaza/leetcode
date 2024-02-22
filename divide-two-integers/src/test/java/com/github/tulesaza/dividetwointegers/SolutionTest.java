package com.github.tulesaza.dividetwointegers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "-2147483648,2,-1073741824",
           "10,3,3",
            "7,-2,-3",
            "100,1,100",
            "2147483647,3,715827882",
            "-2147483648,-1,2147483647",
            "-2147483648,1,-2147483648",
            "2147483647,1,2147483647",
            "-2147483648,-3,715827882"

    })
    void divide(int dividend, int divisor, int expected) {
        assertEquals(expected, solution.divide(dividend, divisor));
    }

}