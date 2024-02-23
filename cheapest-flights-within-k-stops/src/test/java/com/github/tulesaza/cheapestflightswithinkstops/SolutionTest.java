package com.github.tulesaza.cheapestflightswithinkstops;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution bfs = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void testBfs(int n, int[][] flights, int src, int dst, int k, int expectedPrice) {
        assertEquals(expectedPrice, bfs.findCheapestPrice(n, flights, src, dst, k));
    }


    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(4, new int[][]{flight(0, 1, 100), flight(1, 2, 100),
                        flight(2, 0, 100), flight(1, 3, 600), flight(2, 3, 200)}, 0, 3, 1, 700),
                Arguments.of(3, new int[][]{flight(0, 1, 100), flight(1, 2, 100), flight(0, 2, 500)},
                             0, 2, 0, 500),
                Arguments.of(3, new int[][]{flight(0, 1, 100), flight(1, 2, 100), flight(0, 2, 500)},
                             0, 2, 1, 200),

                Arguments.of(5, new int[][]{flight(4, 1, 1), flight(1, 2, 3), flight(0, 3, 2),
                        flight(0, 4, 10), flight(3, 1, 1), flight(1, 4, 3)}, 2, 1, 1, -1),


                Arguments.of(15, new int[][]{flight(10, 14, 43), flight(1, 12, 62), flight(4, 2, 62), flight(14, 10,
                                                                                                             49), flight(
                        9, 5, 29), flight(13, 7, 53), flight(4, 12, 90), flight(14, 9, 38), flight(11, 2, 64), flight(2,
                                                                                                                      13,
                                                                                                                      92), flight(
                        11, 5, 42), flight(10, 1, 89), flight(14, 0, 32), flight(9, 4, 81), flight(3, 6, 97), flight(7,
                                                                                                                     13,
                                                                                                                     35), flight(
                        11, 9, 63), flight(5, 7, 82), flight(13, 6, 57), flight(4, 5, 100), flight(2, 9, 34), flight(11,
                                                                                                                     13,
                                                                                                                     1), flight(
                        14, 8, 1), flight(12, 10, 42), flight(2, 4, 41), flight(0, 6, 55), flight(5, 12, 1), flight(13,
                                                                                                                    3,
                                                                                                                    67), flight(
                        3, 13, 36), flight(3, 12, 73), flight(7, 5, 72), flight(5, 6, 100), flight(7, 6, 52), flight(4,
                                                                                                                     7,
                                                                                                                     43), flight(
                        6, 3, 67), flight(3, 1, 66), flight(8, 12, 30), flight(8, 3, 42), flight(9, 3, 57), flight(12,
                                                                                                                   6,
                                                                                                                   31), flight(
                        2, 7, 10), flight(14, 4, 91), flight(2, 3, 29), flight(8, 9, 29), flight(2, 11, 65), flight(3,
                                                                                                                    8,
                                                                                                                    49), flight(
                        6, 14, 22), flight(4, 6, 38), flight(13, 0, 78), flight(1, 10, 97), flight(8, 14, 40), flight(7,
                                                                                                                      9,
                                                                                                                      3), flight(
                        14, 6, 4), flight(4, 8, 75), flight(1, 6, 56)

                }, 1, 4, 10, 169),
                Arguments.of(4, new int[][]{flight(0, 1, 1), flight(0, 2, 5), flight(1, 2, 1), flight(2, 3, 1)}, 0, 3,
                             1, 6),
                Arguments.of(5,
                             new int[][]{flight(0, 1, 5), flight(1, 2, 5), flight(0, 3, 2), flight(3, 1, 2), flight(1,
                                                                                                                    4,
                                                                                                                    1), flight(
                                     4, 2, 1)}, 0, 2, 2, 7)
        );
    }

    private static int[] flight(int src, int dst, int price) {
        return new int[]{src, dst, price};
    }
}