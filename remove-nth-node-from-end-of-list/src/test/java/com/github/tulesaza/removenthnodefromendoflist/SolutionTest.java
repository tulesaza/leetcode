package com.github.tulesaza.removenthnodefromendoflist;

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
    void removeNthFromEnd(List<Integer> input, int n, List<Integer> output) {
        ListNode head = listCreator.fromList(input);
        ListNode result = solution.removeNthFromEnd(head, n);
        assertThat(output).isEqualTo(listCreator.toList(result));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), 2, List.of(1, 2, 3, 5)),
                Arguments.of(List.of(1), 1, Collections.emptyList()),
                Arguments.of(List.of(1, 2), 1, List.of(1)),
                Arguments.of(List.of(1, 2, 3, 4, 5), 3, List.of(1, 2, 4, 5)),
                Arguments.of(List.of(1, 2), 2, List.of(2))
        );
    }
}