package com.github.tulesaza.productofarrayexceptself;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void productExceptSelf(int[] nums, int[] expected) {
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }


    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(arr(1, 2, 3, 4), arr(24, 12, 8, 6)),
                Arguments.of(arr(1, 1), arr(1, 1)),
                Arguments.of(arr(3, 2), arr(2, 3)),
                Arguments.of(arr(1, -1, 0, 3, -3), arr(0, 0, 9, 0, 0)),
                Arguments.of(arr(0, 0), arr(0, 0))
        );
    }

    static int[] arr(int... a) {
        return a;
    }

}