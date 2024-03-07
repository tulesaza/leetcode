package com.github.tulesaza.middleofthelinkedlist;

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
    void middleNode(List<Integer> input, List<Integer> output) {
        ListNode head = listCreator.fromList(input);
        ListNode middle = solution.middleNode(head);
        assertThat(output).isEqualTo(listCreator.toList(middle));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), List.of(3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(4, 5, 6)),
                Arguments.of(List.of(1), List.of(1)),
                Arguments.of(List.of(1, 2), List.of(2))
        );
    }
}