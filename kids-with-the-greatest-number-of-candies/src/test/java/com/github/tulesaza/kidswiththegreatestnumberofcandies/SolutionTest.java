package com.github.tulesaza.kidswiththegreatestnumberofcandies;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void kidsWithCandies(int[] arr, int extra, List<Boolean> expected) {
        assertThat(expected).isEqualTo(solution.kidsWithCandies(arr, extra));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 5, 1, 3}, 3, List.of(true, true, true, false, true)),
                Arguments.of(new int[]{4, 2, 1, 1, 2}, 1, List.of(true, false, false, false, false)),
                Arguments.of(new int[]{12, 1, 12}, 10, List.of(true, false, true))
        );
    }
}