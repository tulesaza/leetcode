package com.github.tulesaza.numberofstepstoreduceanumbertozero;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "14, 6",
            "8, 4",
            "1, 1",
            "0, 0",
            "123, 12"
    })
    void numberOfSteps(int num, int steps) {
        assertEquals(steps, solution.numberOfSteps(num));
    }
}