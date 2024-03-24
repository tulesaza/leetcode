package com.github.tulesaza.reorderlist;

import com.github.tulesaza.leetcodelinkedlist.LeetcodeListCreator;
import com.github.tulesaza.leetcodelinkedlist.ListCreator;
import com.github.tulesaza.leetcodelinkedlist.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    final ListCreator listCreator = new LeetcodeListCreator();
    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void reorderList1(List<Integer> input, List<Integer> expected) {
        ListNode head = listCreator.fromList(input);
        solution.reorderList1(head);
        List<Integer> result = listCreator.toList(head);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void reorderList2(List<Integer> input, List<Integer> expected) {
        ListNode head = listCreator.fromList(input);
        solution.reorderList2(head);
        List<Integer> result = listCreator.toList(head);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4), List.of(1, 4, 2, 3)),
                Arguments.of(List.of(1, 2, 3, 4, 5), List.of(1, 5, 2, 4, 3)),
                Arguments.of(List.of(1), List.of(1)),
                Arguments.of(List.of(1, 2), List.of(1, 2)),
                Arguments.of(List.of(1, 2, 3), List.of(1, 3, 2)));
    }
}