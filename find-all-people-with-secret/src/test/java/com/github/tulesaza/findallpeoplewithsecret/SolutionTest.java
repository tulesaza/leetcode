package com.github.tulesaza.findallpeoplewithsecret;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void findAllPeople(int n, int[][] meetings, int firstPerson, List<Integer> expected) {
        var result = new HashSet<>(solution.findAllPeople(n, meetings, firstPerson));
        var expectedSet = new HashSet<>(expected);
        assertTrue(result.containsAll(expectedSet) && expectedSet.containsAll(result),
                   "expected %s, but was %s".formatted(expectedSet, result));
    }


    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(6, new int[][]{meeting(1, 2, 5), meeting(2, 3, 8), meeting(1, 5, 10)}, 1,
                             List.of(0, 1, 2, 3, 5)),
                Arguments.of(4, new int[][]{meeting(3, 1, 3), meeting(1, 2, 2), meeting(0, 3, 3)}, 3, List.of(0, 1, 3)),
                Arguments.of(5, new int[][]{meeting(3, 4, 2), meeting(1, 2, 1), meeting(2, 3, 1)}, 1,
                             List.of(0, 1, 2, 3, 4)),
                Arguments.of(5, new int[][]{meeting(1, 4, 3), meeting(0, 4, 3)}, 3, List.of(0, 1, 3, 4)),
                Arguments.of(10, new int[][]{
                        meeting(1, 2, 1), meeting(2, 3, 1), meeting(3, 4, 1), meeting(4, 5, 1),
                        meeting(5, 6, 1), meeting(6, 7, 1), meeting(7, 8, 1), meeting(9, 8, 1)
                }, 9, List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
        );
    }


    private static int[] meeting(int x, int y, int time) {
        return new int[]{x, y, time};
    }
}