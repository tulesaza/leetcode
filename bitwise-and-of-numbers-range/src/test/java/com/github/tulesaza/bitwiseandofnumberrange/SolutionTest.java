package com.github.tulesaza.bitwiseandofnumberrange;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "5,7,4",
            "0,0,0",
            "1,2147483647,0",
            "2147483646, 2147483647, 2147483646",
            "2147483647, 2147483647, 2147483647",
            "1073741824, 2147483647, 1073741824"
    })
    void rangeBitwiseAnd(int l, int r, int and) {
        assertEquals(and, solution.rangeBitwiseAnd1(l, r));
        assertEquals(and, solution.rangeBitwiseAnd2(l, r));
    }

}