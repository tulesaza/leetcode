import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void generateTest(int numberOfRows, List<List<Integer>> expected) {
        assertEquals(expected, solution.generate(numberOfRows));
    }


    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(1, List.of(List.of(1))),
                Arguments.of(2, List.of(List.of(1), List.of(1, 1))),
                Arguments.of(3, List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1))),
                Arguments.of(4, List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1)))
        );
    }

}
