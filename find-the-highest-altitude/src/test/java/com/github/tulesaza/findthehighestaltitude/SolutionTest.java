package com.github.tulesaza.findthehighestaltitude;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void largestAltitude(int[] gain, int highestAltitude) {
        assertEquals(highestAltitude, solution.largestAltitude(gain));
    }


    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{-5, 1, 5, 0, -7}, 1),
                Arguments.of(new int[]{-4, -3, -2, -1, 4, 3, 2}, 0)
        );
    }
}