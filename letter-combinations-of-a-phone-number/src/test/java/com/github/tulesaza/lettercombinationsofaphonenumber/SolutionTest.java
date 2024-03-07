package com.github.tulesaza.lettercombinationsofaphonenumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void letterCombinations(String digits, Set<String> expected) {
        Set<String> result = new HashSet<>(solution.letterCombinations(digits));
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @ParameterizedTest
    @MethodSource("data")
    void letterCombinations2(String digits, Set<String> expected) {
        Set<String> result = new HashSet<>(solution.letterCombinations2(digits));
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("23", Set.of("ad", "bd", "cd", "ae", "be", "ce", "af", "bf", "cf")),
                Arguments.of("", Set.of()),
                Arguments.of("2", Set.of("a", "b", "c"))
        );
    }

}