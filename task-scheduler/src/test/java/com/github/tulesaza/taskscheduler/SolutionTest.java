package com.github.tulesaza.taskscheduler;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "AAABBB, 1, 6",
            "ABABAB, 3, 10",
            "AAABBB, 2, 8",
            "ABCDAB, 4, 7",
            "AAAAA, 0, 5",
            "AAABBBCCB, 3, 13",// BAC inter BAC inter BA  inter inter B
            "AAA, 3, 9", // A i i i A iii A,
            "AAAAAABCDEFG, 1, 12" // A B A C A D A E A F A G

    })
    void leastInterval(String tasks, int n, int expected) {

        assertEquals(expected, solution.leastInterval(tasks.toCharArray(), n));
    }
}