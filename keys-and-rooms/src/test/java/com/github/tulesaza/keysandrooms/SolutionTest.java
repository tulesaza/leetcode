package com.github.tulesaza.keysandrooms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void canVisitAllRooms(List<List<Integer>> rooms, boolean expected) {
        assertEquals(expected, solution.canVisitAllRooms(rooms));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(List.of(List.of(1), List.of(2), List.of(3), Collections.emptyList()), true),
                Arguments.of(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0)), false)
        );
    }

}