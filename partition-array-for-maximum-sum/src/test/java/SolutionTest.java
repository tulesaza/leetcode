import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {


    @ParameterizedTest
    @MethodSource(value = "argumentProvider")
    void bottomUp(int[] arr, int k, int result) {
        var solution = new Solution(Solution.Approach.BOTTOM_UP);
        assertEquals(result, solution.maxSumAfterPartitioning(arr, k));
    }


    @ParameterizedTest
    @MethodSource(value = "argumentProvider")
    void topDown(int[] arr, int k, int result) {
        var solution = new Solution(Solution.Approach.TOP_DOWN);
        assertEquals(result, solution.maxSumAfterPartitioning(arr, k));
    }


    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 15, 7, 9, 2, 5, 10}, 3, 84),
                Arguments.of(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4, 83),
                Arguments.of(new int[]{1}, 1, 1),
                Arguments.of(new int[]{1, 2}, 1, 3),
                Arguments.of(new int[]{1, 2}, 2, 4)
        );
    }
}