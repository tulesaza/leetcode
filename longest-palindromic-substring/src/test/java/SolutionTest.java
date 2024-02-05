import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "babad, bab|aba",
            "cbbd, bb",
            "abcabc, a|b|c",
    })
    void longestPalindrome(String input, String output) {
        var expectedPalindromes = Arrays.stream(output.split("\\|"))
                .filter(Objects::nonNull)
                .filter(s -> !s.isBlank())
                .collect(Collectors.toSet());
        var result = solution.longestPalindrome(input);
        assertTrue(expectedPalindromes.contains(result), "%s is not in %s".formatted(result, expectedPalindromes));
    }
}