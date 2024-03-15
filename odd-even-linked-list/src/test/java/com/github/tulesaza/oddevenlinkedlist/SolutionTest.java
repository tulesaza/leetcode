package com.github.tulesaza.oddevenlinkedlist;

import com.github.tulesaza.leetcodelinkedlist.LeetcodeListCreator;
import com.github.tulesaza.leetcodelinkedlist.ListCreator;
import com.github.tulesaza.leetcodelinkedlist.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    final Solution solution = new Solution();
    final ListCreator listCreator = new LeetcodeListCreator();

    @ParameterizedTest
    @MethodSource("data")
    void oddEvenList(List<Integer> input, List<Integer> expected) {
        ListNode head = listCreator.fromList(input);
        ListNode out = solution.oddEvenList(head);
        assertThat(listCreator.toList(out)).isEqualTo(expected);
    }


    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), List.of(1, 3, 5, 2, 4)),
                Arguments.of(List.of(1), List.of(1)),
                Arguments.of(Collections.emptyList(), Collections.emptyList()),
                Arguments.of(List.of(1, 4, 2), List.of(1, 2, 4)),
                Arguments.of(List.of(2, 1, 3, 5, 6, 4, 7), List.of(2, 3, 6, 7, 1, 5, 4)),
                Arguments.of(List.of(111, 23, 43, 49), List.of(111, 43, 23, 49))

        );
    }
}