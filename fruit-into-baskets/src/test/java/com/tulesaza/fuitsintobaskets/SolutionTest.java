package com.tulesaza.fuitsintobaskets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {


    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void totalFruit(int[] trees, int maxNumberOfTrees) {
        assertEquals(maxNumberOfTrees, solution.totalFruit(trees));

    }

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1}, 3),
                Arguments.of(new int[]{0, 1, 2, 2}, 3),
                Arguments.of(new int[]{1, 2, 3, 2, 2}, 4),
                Arguments.of(new int[]{2, 2, 2, 2, 2}, 5)

        );
    }
}