import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbStairsSolutionTest {

    @ParameterizedTest
    @MethodSource("climbStairsArgumentProvider")
    void testBottomUp(int n, int expected) {
        var solution = new Solution(Solution.Approach.BOTTOM_UP);
        assertEquals(expected, solution.climbStairs(n));
    }


    @ParameterizedTest
    @MethodSource("climbStairsArgumentProvider")
    void testTopDown(int n, int expected) {
        var solution = new Solution(Solution.Approach.TOP_DOWN);
        assertEquals(expected, solution.climbStairs(n));
    }

    private static Stream<Arguments> climbStairsArgumentProvider() {
        return Stream.of(
                Arguments.of(2, 2),
                Arguments.of(3, 3)
        );
    }
}