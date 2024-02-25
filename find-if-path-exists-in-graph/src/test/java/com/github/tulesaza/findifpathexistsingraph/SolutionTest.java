package com.github.tulesaza.findifpathexistsingraph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.github.tulesaza.findifpathexistsingraph.Solution.Approach.BFS;
import static com.github.tulesaza.findifpathexistsingraph.Solution.Approach.UNION_FIND;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {


    @ParameterizedTest
    @MethodSource("data")
    void validPathBfs(int n, int[][] edges, int src, int dst, boolean exists) {
        final var bfs = new Solution(BFS);
        assertEquals(exists, bfs.validPath(n, edges, src, dst));
    }

    @ParameterizedTest
    @MethodSource("data")
    void validPathUnionFind(int n, int[][] edges, int src, int dst, boolean exists) {
        final var uf = new Solution(UNION_FIND);
        assertEquals(exists, uf.validPath(n, edges, src, dst));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(3, new int[][]{edge(0, 1), edge(1, 2), edge(2, 0)}, 0, 2, true),
                Arguments.of(6, new int[][]{edge(0, 1), edge(0, 2), edge(3, 5), edge(5, 4), edge(4, 3)}, 0, 5, false)
        );
    }


    static int[] edge(int a, int b) {
        return new int[]{a, b};
    }
}