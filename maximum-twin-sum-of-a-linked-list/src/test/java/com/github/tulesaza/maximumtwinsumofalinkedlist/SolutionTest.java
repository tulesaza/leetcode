package com.github.tulesaza.maximumtwinsumofalinkedlist;

import com.github.tulesaza.leetcodelinkedlist.LeetcodeListCreator;
import com.github.tulesaza.leetcodelinkedlist.ListCreator;
import com.github.tulesaza.leetcodelinkedlist.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final ListCreator listCreator = new LeetcodeListCreator();
    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void pairSum(List<Integer> list, int sum) {
        ListNode head = listCreator.fromList(list);
        assertEquals(sum, solution.pairSum(head));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(List.of(1, 2), 3),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7),
                Arguments.of(List.of(4, 2, 2, 3), 7),
                Arguments.of(List.of(100000, 2, 3, 100000), 200000)
        );
    }
}