package com.github.tulesaza.sqrtx;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "4, 2",
            "8, 2",
            "9, 3",
            "0, 0",
            "1, 1"
    })
    void mySqrt(int x, int sqrtX) {
        assertEquals(sqrtX, solution.mySqrt(x));
    }
}