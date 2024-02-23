package com.github.tulesaza.numberof1bits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "11, 3",
            "128, 1",
            "2147483647, 31",
            "-3, 31"
    })
    void hammingWeight(int value, int onesCount) {
        assertEquals(onesCount, solution.hammingWeight(value));
        assertEquals(onesCount, solution.buildInHammingWeigh(value));
    }
}