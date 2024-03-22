package com.github.tulesaza.editdistance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "ros, horse, 3",
            "intention, execution, 5",
            "aza, aza, 0",
            "aza, za, 1"
    })
    void minDistance(String s1, String s2, int expected) {
        assertEquals(expected, solution.minDistance(s1, s2));
    }
}