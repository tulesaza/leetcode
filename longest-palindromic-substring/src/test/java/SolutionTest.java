import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {


    @ParameterizedTest
    @MethodSource(value = "argumentProvider")
    void extendFromCenter(String input, Set<String> expectedPalindromes) {
        var solution = new Solution();
        var result = solution.longestPalindrome(input);
        assertTrue(expectedPalindromes.contains(result), "%s is not in %s".formatted(result, expectedPalindromes));
    }

    @ParameterizedTest
    @MethodSource(value = "argumentProvider")
    void manacher(String input, Set<String> expectedPalindromes) {
        var solution = new ManachersAlgorithm();
        var result = solution.longestPalindrome(input);
        assertTrue(expectedPalindromes.contains(result), "%s is not in %s".formatted(result, expectedPalindromes));
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
                Arguments.of("babad", Set.of("bab", "aba")),
                Arguments.of("cbbd", Set.of("bb")),
                Arguments.of("abcabc", Set.of("a", "b", "c")),
                Arguments.of("abcdefedghihgdefedcbz", Set.of("bcdefedghihgdefedcb")), // case A
                Arguments.of("abcdedcbahihabcdedcxyz", Set.of("cdedcbahihabcdedc")), // case B
                Arguments.of("abcdedcfghihgfcdedcfgz", Set.of("cdedcfghihgfcdedc")) // case C
        );
    }
}