package com.github.tulesaza.findthepivotinteger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "8, 6",
            "1, 1",
            "4, -1"
    })
    void pivotInteger(int n, int k) {
        assertEquals(k, solution.pivotInteger(n));
    }
}