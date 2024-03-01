package com.github.tulesaza.leetcodelinkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LeetcodeListCreatorTest {

    final ListCreator listCreator = new LeetcodeListCreator();

    @ParameterizedTest
    @MethodSource("data")
    void serde(List<Integer> list) {
        ListNode node = listCreator.fromList(list);
        assertThat(list).isEqualTo(listCreator.toList(node));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(2)),
                Arguments.of(Collections.emptyList())
        );
    }
}