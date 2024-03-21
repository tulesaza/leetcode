package com.github.tulesaza.reverselinkedlist;

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

    final ListCreator listCreator = new LeetcodeListCreator();
    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void reverseList(List<Integer> list, List<Integer> reversed) {
        ListNode input = listCreator.fromList(list);
        ListNode result = solution.reverseList(input);
        assertThat(listCreator.toList(result)).isEqualTo(reversed);
    }

    @ParameterizedTest
    @MethodSource("data")
    void reverseRecursive(List<Integer> list, List<Integer> reversed) {
        ListNode input = listCreator.fromList(list);
        ListNode result = solution.reverseRecursive(input);
        assertThat(listCreator.toList(result)).isEqualTo(reversed);
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), List.of(5, 4, 3, 2, 1)),
                Arguments.of(List.of(1, 2), List.of(2, 1)),
                Arguments.of(List.of(1), List.of(1)),
                Arguments.of(Collections.emptyList(), Collections.emptyList())

        );
    }
}