package com.github.tulesaza.combinationsumiii;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void combinationSum3(int k, int n, List<List<Integer>> expected) {
        List<List<Integer>> result = solution.combinationSum3(k, n);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(3, 7, List.of(List.of(1, 2, 4))),
                Arguments.of(3, 9, List.of(List.of(1, 2, 6), List.of(1, 3, 5), List.of(2, 3, 4))),
                Arguments.of(4, 1, Collections.emptyList())

        );
    }
}