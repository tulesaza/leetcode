package com.tulesaza.findallanagramsinastring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void findAnagrams(String longerWord, String searchWord, Set<Integer> expectedStartIndices) {
        var result = new HashSet<>(solution.findAnagrams(longerWord, searchWord));
        assertTrue(expectedStartIndices.containsAll(result) && result.containsAll(expectedStartIndices));

    }

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("cbaebabacd", "abc", Set.of(0, 6)),
                Arguments.of("abab", "ab", Set.of(0, 1, 2))

        );
    }
}