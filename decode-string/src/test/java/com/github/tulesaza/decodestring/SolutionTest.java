package com.github.tulesaza.decodestring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "2[b]3[cd], bbcdcdcd",
            "2[sd3[a]], sdaaasdaaa",
            "2[abc]3[cd]ef, abcabccdcdcdef",
            "12[code], codecodecodecodecodecodecodecodecodecodecodecode"

    })
    void decodeString(String decoded, String encoded) {
        assertEquals(encoded, solution.decodeString(decoded));
    }
}