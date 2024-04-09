package com.github.tulesaza.numberofstudentsunabletoeatlunch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void countStudents(int[] students, int[] sandwiches, int expected) {
        assertEquals(expected, solution.countStudents(students, sandwiches));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(arr(1, 1, 0, 0), arr(0, 1, 0, 1), 0),
                Arguments.of(arr(1, 1, 1, 0, 0, 1), arr(1, 0, 0, 0, 1, 1), 3),
                Arguments.of(arr(1, 0, 1, 1), arr(0, 1, 1, 0), 1)
        );

    }

    static int[] arr(int... a) {
        return a;
    }
}