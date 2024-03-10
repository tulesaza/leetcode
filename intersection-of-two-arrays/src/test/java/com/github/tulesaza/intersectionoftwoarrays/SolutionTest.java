package com.github.tulesaza.intersectionoftwoarrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void intersection2(int[] a, int[] b, Set<Integer> expected) {
        List<Integer> c = Arrays.stream(solution.intersection2(a, b)).boxed().toList();
        Set<Integer> result = new HashSet<>(c);
        assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }

    @ParameterizedTest
    @MethodSource("data")
    void intersection3(int[] a, int[] b, Set<Integer> expected) {
        List<Integer> c = Arrays.stream(solution.intersection3(a, b)).boxed().toList();
        Set<Integer> result = new HashSet<>(c);
        assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(arr(1, 2, 2, 1), arr(2, 2), Set.of(2)),
                Arguments.of(arr(4, 9, 5), arr(9, 4, 9, 8, 4), Set.of(4, 9))
        );
    }

    static int[] arr(int... a) {
        return a;
    }


}