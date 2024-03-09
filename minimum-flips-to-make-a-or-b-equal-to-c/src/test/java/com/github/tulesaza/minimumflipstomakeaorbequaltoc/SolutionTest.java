package com.github.tulesaza.minimumflipstomakeaorbequaltoc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "2,6,5,3",
            "4,2,7,1",
            "1,2,3,0"
    })
    void minFlips(int a, int b, int c, int flips) {
        assertEquals(flips, solution.minFlips(a, b, c));
    }
}