import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<String> generateParenthesis(int n) {
        if (n < 2) {
            return List.of("()");
        }
        LinkedList<Combination> result = new LinkedList<>();
        result.push(new Combination(1, 0, "("));
        int length = 1;
        while (length < 2 * n) {
            LinkedList<Combination> tmp = new LinkedList<>();
            while (!result.isEmpty()) {
                var current = result.pop();
                if (current.openers() < n) {
                    tmp.add(new Combination(current.openers() + 1, current.closers(), current.combination() + "("));
                }
                if (current.closers() < current.openers()) {
                    tmp.add(new Combination(current.openers(), current.closers() + 1, current.combination() + ")"));
                }
            }
            result = tmp;
            length++;
        }

        return result.stream().map(Combination::combination).toList();

    }

    record Combination(int openers, int closers, String combination) {
    }
}