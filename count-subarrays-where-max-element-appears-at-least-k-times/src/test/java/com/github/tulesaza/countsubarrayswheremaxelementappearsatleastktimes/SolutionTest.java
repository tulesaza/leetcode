package com.github.tulesaza.countsubarrayswheremaxelementappearsatleastktimes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void countSubarrays1(int[] nums, int k, long expected) {
        assertEquals(expected, solution.countSubarrays1(nums, k));
    }

    @ParameterizedTest
    @MethodSource("data")
    void countSubarrays2(int[] nums, int k, long expected) {
        assertEquals(expected, solution.countSubarrays2(nums, k));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1, 1),
                Arguments.of(new int[]{1, 3, 2, 3, 3}, 2, 6),
                Arguments.of(new int[]{1, 4, 2, 1}, 3, 0),
                Arguments.of(new int[]{3, 3, 3, 3}, 1, 10),
                Arguments.of(IntStream.range(0, (int) 1e5).map(a -> 5).toArray(), 1, 5000050000L)
        );
    }
}