package com.github.tulesaza.findthetownjudge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void findJudge(int peopleCount, int[][] trust, int townJudgeLabel) {
        assertEquals(townJudgeLabel, solution.findJudge(peopleCount, trust));
    }


    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(2, new int[][]{pair(1, 2)}, 2),
                Arguments.of(3, new int[][]{pair(1, 3), pair(2, 3)}, 3),
                Arguments.of(3, new int[][]{pair(1, 3), pair(2, 3), pair(3, 1)}, -1)
        );
    }

    static int[] pair(int a, int b) {
        return new int[]{a, b};
    }
}