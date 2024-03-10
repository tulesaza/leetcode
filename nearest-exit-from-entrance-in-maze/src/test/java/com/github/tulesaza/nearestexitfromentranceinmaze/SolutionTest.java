package com.github.tulesaza.nearestexitfromentranceinmaze;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void nearestExit(char[][] maze, int[] entrance, int exit) {
        assertEquals(exit, solution.nearestExit(maze, entrance));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(maze(row('+', '+', '.', '+'), row('.', '.', '.', '+'), row('+', '+', '+', '.')),
                             new int[]{1, 2}, 1),
                Arguments.of(maze(row('+', '+', '+'), row('.', '.', '.'), row('+', '+', '+')), new int[]{1, 0}, 2),
                Arguments.of(maze(row('.', '+')), new int[]{0, 0}, -1)

        );
    }

    static char[] row(char... chars) {
        return chars;
    }

    static char[][] maze(char[]... rows) {
        return rows;
    }
}