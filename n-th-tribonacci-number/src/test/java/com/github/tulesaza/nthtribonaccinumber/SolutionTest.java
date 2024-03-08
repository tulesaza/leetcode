package com.github.tulesaza.nthtribonaccinumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "0, 0",
            "1, 1",
            "2, 1",
            "3, 2",
            "4, 4",
            "25, 1389537"

    })
    void tribonacci(int n, int expected) {
        assertEquals(expected, solution.tribonacci(n));
    }
}