package com.github.tulesaza.dota2senate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "RD, Radiant",
            "RDD, Dire",
            "RDDR, Radiant",
            "R, Radiant",
            "DD, Dire",
            "DR, Dire",
            "RRRDDDD, Radiant"
    })
    void predictPartyVictory(String senate, String winner) {
        assertEquals(winner, solution.predictPartyVictory(senate));
    }
}