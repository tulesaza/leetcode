package com.github.tulesaza.findtheduplicatenumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void findDuplicate1(int[] nums, int duplicate) {
        assertEquals(duplicate, solution.findDuplicate1(nums));
    }

    @ParameterizedTest
    @MethodSource("data")
    void findDuplicate2(int[] nums, int duplicate) {
        assertEquals(duplicate, solution.findDuplicate2(nums));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 2, 2}, 2),
                Arguments.of(new int[]{3, 1, 3, 4, 2}, 3),
                Arguments.of(new int[]{3, 3, 3, 3, 3}, 3)
        );
    }
}