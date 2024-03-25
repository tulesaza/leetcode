package com.github.tulesaza.findallduplicatesinanarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void findDuplicates(int[] nums, List<Integer> duplicates) {
        List<Integer> result = solution.findDuplicates(nums);
        assertThat(result).hasSameElementsAs(duplicates);
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 3, 2}, List.of(1)),
                Arguments.of(new int[]{1}, Collections.emptyList()),
                Arguments.of(new int[]{4, 3, 2, 7, 8, 2, 3, 1}, List.of(2, 3)),
                Arguments.of(IntStream.range(1, 100001).toArray(), Collections.emptyList()),
                Arguments.of(new int[]{1, 1, 2, 2}, List.of(1, 2))
        );
    }
}