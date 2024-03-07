package com.github.tulesaza.canplaceflowers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void canPlaceFlowers(int[] flowerbed, int n, boolean can) {
        assertEquals(can, solution.canPlaceFlowers(flowerbed, n));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 0, 0, 1}, 1, true),
                Arguments.of(new int[]{1, 0, 0, 0, 1}, 2, false),
                Arguments.of(new int[]{1, 0, 0, 0, 0}, 1, true)
        );
    }
}