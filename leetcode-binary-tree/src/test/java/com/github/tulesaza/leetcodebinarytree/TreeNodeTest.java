package com.github.tulesaza.leetcodebinarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class TreeNodeTest {

    @ParameterizedTest
    @MethodSource("data")
    void serdeTest(List<Integer> list) {
        assertThat(list).isEqualTo(TreeNode.fromList(list).toList());
    }

    static Stream<Arguments> data() {
        return Stream.of(
                /*Arguments.of(List.of(1)),
                Arguments.of(List.of(1, 2, 3)),*/
                Arguments.of(list(1, 2, 3, 4, null, 5, 6, null, null, 7))
        );
    }

    static List<Integer> list(Integer... nums) {
        return new ArrayList<>(Arrays.asList(nums));
    }
}