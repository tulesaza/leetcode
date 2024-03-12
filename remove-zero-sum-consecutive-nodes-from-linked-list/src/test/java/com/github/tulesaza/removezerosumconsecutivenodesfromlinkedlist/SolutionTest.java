package com.github.tulesaza.removezerosumconsecutivenodesfromlinkedlist;

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

    final Solution solution = new Solution();
    final ListCreator listCreator = new LeetcodeListCreator();

    @ParameterizedTest
    @MethodSource("data")
    void removeZeroSumSublists1(List<Integer> input, List<Integer> expected) {
        ListNode head = listCreator.fromList(input);
        ListNode out = solution.removeZeroSumSublists1(head);
        List<Integer> result = listCreator.toList(out);
        assertThat(result).isEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("data")
    void removeZeroSumSublists2(List<Integer> input, List<Integer> expected) {
        ListNode head = listCreator.fromList(input);
        ListNode out = solution.removeZeroSumSublists2(head);
        List<Integer> result = listCreator.toList(out);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(List.of(1, 2, -3, 3, 1), List.of(3, 1)),
                Arguments.of(List.of(1, 2, 3, -3, 4), List.of(1, 2, 4)),
                Arguments.of(List.of(1, 2, 3, -3, -2), List.of(1)));
    }
}