package com.github.tulesaza.lengthoflastword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void lengthOfLastWord1(String s, int expected) {
        assertEquals(expected, solution.lengthOfLastWord1(s));
    }

    @ParameterizedTest
    @MethodSource("data")
    void lengthOfLastWord2(String s, int expected) {
        assertEquals(expected, solution.lengthOfLastWord2(s));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("Hello world", 5),
                Arguments.of("a", 1),
                Arguments.of("Hello world   ", 5),
                Arguments.of("Hello world asm", 3),
                Arguments.of("  Hello    world     ", 5),
                Arguments.of("s".repeat(10000), 10000),
                Arguments.of("%s%s%s".formatted(" ".repeat(4999), "a", " ".repeat(5000)), 1),
                Arguments.of("%sa".formatted(" ".repeat(9999)), 1),
                Arguments.of("a%s".formatted(" ".repeat(9999)), 1)
        );

    }
}