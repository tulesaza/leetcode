package com.github.tulesaza.numberofchangingkeys;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "aaaAAaa, 0",
            "aAAaBbbbDd, 2",
            "a, 0",
            "aAbBcC, 2"
    })
    void countKeyChanges(String s, int changes) {
        assertEquals(changes, solution.countKeyChanges(s));
    }
}