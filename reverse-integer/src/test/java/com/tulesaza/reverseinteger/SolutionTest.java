package com.tulesaza.reverseinteger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void reverse(int input, int expected) {

        assertEquals(expected, solution.reverse(input));
    }


    @ParameterizedTest
    @MethodSource("data")
    void reverseWithStack(int input, int expected) {
        assertEquals(expected, solution.reverseWithStack(input));
    }

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(123, 321),
                Arguments.of(-100, -1),
                Arguments.of(12345, 54321),
                Arguments.of(Integer.MIN_VALUE, 0),
                Arguments.of(Integer.MIN_VALUE + 1, 0),
                Arguments.of(Integer.MAX_VALUE - 1, 0),
                Arguments.of(Integer.MAX_VALUE, 0),
                Arguments.of(Integer.MAX_VALUE / 10, 463847412)
        );
    }
}