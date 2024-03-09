package com.github.tulesaza.minimumcommonvalue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void getCommon(int[] n1, int[] n2, int expected) {
        assertEquals(expected, solution.getCommon(n1, n2));
    }


    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(arr(1, 2, 3, 4, 5), arr(2, 3, 4, 5), 2),
                Arguments.of(arr(1, 2, 3, 4, 5), arr(5, 6), 5),
                Arguments.of(arr(1, 2, 3), arr(4, 5), -1),
                Arguments.of(arr(1), arr(1), 1));
    }

    static int[] arr(int... a) {
        return a;
    }

}