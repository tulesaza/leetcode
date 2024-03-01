package com.github.tulesaza.deletethemiddlenodeofalinkedlist;

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
    void deleteMiddle(List<Integer> list, List<Integer> expected) {
        ListNode input = listCreator.fromList(list);
        ListNode output = solution.deleteMiddle(input);
        assertThat(expected).isEqualTo(listCreator.toList(output));
    }


    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(List.of(1, 3, 4, 7, 1, 2, 6), List.of(1, 3, 4, 1, 2, 6)),
                Arguments.of(List.of(1, 2, 3, 4), List.of(1, 2, 4)),
                Arguments.of(List.of(2, 1), List.of(2))
        );
    }
}