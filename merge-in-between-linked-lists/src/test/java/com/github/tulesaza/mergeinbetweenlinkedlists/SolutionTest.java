package com.github.tulesaza.mergeinbetweenlinkedlists;

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

    ListCreator listCreator = new LeetcodeListCreator();
    Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void mergeInBetween(List<Integer> list1, int a, int b, List<Integer> list2, List<Integer> expected) {
        ListNode head1 = listCreator.fromList(list1);
        ListNode head2 = listCreator.fromList(list2);
        ListNode result = solution.mergeInBetween(head1, a, b, head2);
        assertThat(listCreator.toList(result)).isEqualTo(expected);
    }


    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), 1, 3, List.of(13, 22, 87), List.of(1, 13, 22, 87, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5), 2, 2, List.of(3), List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7, 8), 2, 4, List.of(100), List.of(1, 2, 100, 6, 7, 8))

        );
    }
}