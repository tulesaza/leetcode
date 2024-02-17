package com.tulesaza.permutationinstring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "ab, eidbaooo, true",
            "ab, eidboaoo, false",
            "baca, azacbam, true"
    })
    void checkInclusion(String s1, String s2, boolean expected) {
        assertEquals(expected, solution.checkInclusion(s1, s2));
    }
}