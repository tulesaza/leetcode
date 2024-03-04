package com.github.tulesaza.bagoftokens;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void bagOfTokensScore(int[] tokens, int power, int expectedScore) {
        assertEquals(expectedScore, solution.bagOfTokensScore(tokens, power));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{100, 400, 300, 200}, 200, 2),
                Arguments.of(new int[]{100}, 50, 0),
                Arguments.of(new int[]{}, 100000, 0),
                Arguments.of(new int[]{100, 200, 300, 400}, 1000, 4),
                Arguments.of(new int[]{100, 200}, 50, 0),
                Arguments.of(new int[]{100, 200}, 100, 1)
        );
    }
}