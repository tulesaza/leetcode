package com.github.tulesaza.linkedlistcycle;

import com.github.tulesaza.leetcodelinkedlist.LeetcodeListCreator;
import com.github.tulesaza.leetcodelinkedlist.ListCreator;
import com.github.tulesaza.leetcodelinkedlist.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final ListCreator listCreator = new LeetcodeListCreator();
    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void hasCycle(List<Integer> list, int cycleIndex) {
        ListNode head = listCreator.fromList(list, cycleIndex);
        assertEquals(cycleIndex != -1, solution.hasCycle(head));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(Collections.emptyList(), -1),
                Arguments.of(List.of(1), -1),
                Arguments.of(List.of(1, 2), 0),
                Arguments.of(List.of(3, 2, 0, -4), 1)
        );
    }

}