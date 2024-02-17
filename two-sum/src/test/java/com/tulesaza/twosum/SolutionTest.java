package com.tulesaza.twosum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void twoSum(int[] input, int sum, int[] expectedIndicies) {
        var result = solution.twoSum(input, sum);
        Arrays.sort(expectedIndicies);
        Arrays.sort(result);
        assertArrayEquals(expectedIndicies, result);
    }

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{1, 0})
        );
    }

}