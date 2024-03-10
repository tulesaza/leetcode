package com.github.tulesaza.uniquepaths;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "3,7,28",
            "3,2,3",
            "8,5,330"
    })
    void uniquePaths(int rows, int columns, int paths) {
        assertEquals(paths, solution.uniquePaths(rows, columns));
    }
}