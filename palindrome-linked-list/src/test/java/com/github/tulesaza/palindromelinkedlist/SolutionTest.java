package com.github.tulesaza.palindromelinkedlist;

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
    void isPalindrome(List<Integer> list, boolean expected) {
        ListNode head = listCreator.fromList(list);
        assertEquals(expected, solution.isPalindrome(head));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(List.of(1), true),
                Arguments.of(List.of(1, 2), false),
                Arguments.of(List.of(2, 2), true),
                Arguments.of(List.of(1, 2, 1), true),
                Arguments.of(List.of(1, 2, 3), false),
                Arguments.of(List.of(1, 2, 2, 1), true),
                Arguments.of(List.of(1, 2, 3, 1), false),
                Arguments.of(List.of(1, 2, 3, 4, 5), false),
                Arguments.of(List.of(1, 2, 3, 2, 1), true)
        );
    }
}