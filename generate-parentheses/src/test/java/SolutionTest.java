import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void generateParenthesis(int n, Set<String> expected) {
        var solution = new Solution();
        var result = new HashSet<>(solution.generateParenthesis(n));
        assertTrue(expected.size() == result.size() && expected.containsAll(result) && result.containsAll(expected),
                   getMessage(expected, result));
    }

    private static String getMessage(Set<String> expected, HashSet<String> result) {
        var missing = new HashSet<>(expected);
        missing.removeAll(result);
        return "result=%s,\n expected=%s,\n missing=%s\n".formatted(result, expected, missing);
    }


    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
                Arguments.of(3, Set.of("((()))", "(()())", "(())()", "()(())", "()()()")),
                Arguments.of(2, Set.of("()()", "(())")),
                Arguments.of(1, Set.of("()")),
                Arguments.of(4,
                             Set.of("(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()",
                                    "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"))
        );
    }
}