import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {

    private final Approach approach;

    public Solution(Approach approach) {
        this.approach = approach;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        return switch (approach) {
            case TOP_DOWN -> memoization(arr, k);
            case BOTTOM_UP -> tabulation(arr, k);
        };
    }

    // bottom-up approach
    private int tabulation(int[] arr, int k) {
        int[] maxSum = new int[arr.length + 1]; // maxSum[i] is maximal possible sum till i-index of arr
        maxSum[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            int maxSumSoFar = -1;
            int maxElementInWindow = -1;
            int maxWindowLength = Math.min(i + 1, k);
            // Try to find maximum window
            for (int j = 0; j < maxWindowLength; j++) {
                maxElementInWindow = Math.max(maxElementInWindow, arr[i - j]);
                maxSumSoFar = Math.max(maxSumSoFar, maxElementInWindow * (j + 1) + maxSum[i - j]);
            }

            maxSum[i + 1] = maxSumSoFar;
        }
        return maxSum[maxSum.length - 1];
    }

    // top down
    // [1, 15, 7, 9, 2, 5, 10] k= 3
    // [10] [1, 15, 7, 9, 2, 5]
    // [5,10] [1, 15, 7, 9, 2]
    // [5,10, 2] [1, 15, 7, 9]
    private int memoization(int[] arr, int k) {
        Map<Integer, Integer> indexToMaxSum = new HashMap<>();
        AtomicInteger cacheMatch = new AtomicInteger(0);
        var result = findMax(arr, k, arr.length - 1, indexToMaxSum, cacheMatch);
        System.out.println("Cache matches: " + cacheMatch);
        return result;
    }

    private int findMax(int[] arr, int k, int index, Map<Integer, Integer> cache, AtomicInteger cacheMatch) {
        // special case meaning nothing is lefter than window
        if (index == -1) {
            return 0;
        }
        if (index == 0) {
            cache.put(index, arr[0]);
            return arr[0];
        }
        if (cache.containsKey(index)) {
            cacheMatch.incrementAndGet();
            return cache.get(index);
        }
        int max = -1;
        int maxInWindow = -1;
        for (int i = 0; i < Math.min(index + 1, k); i++) {
            maxInWindow = Math.max(maxInWindow, arr[index - i]);
            // TODO rewrite to optimize tail recursion (carry values in args)
            max = Math.max(max, maxInWindow * (i + 1) + findMax(arr, k, index - i - 1, cache, cacheMatch));
        }

        cache.put(index, max);
        return max;
    }

    enum Approach {
        BOTTOM_UP, TOP_DOWN
    }
}