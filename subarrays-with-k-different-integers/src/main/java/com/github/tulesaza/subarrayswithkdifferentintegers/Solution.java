package com.github.tulesaza.subarrayswithkdifferentintegers;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtMostKDistinct(nums, k) - subarraysWithAtMostKDistinct(nums, k - 1);
    }

    // Includes also k, k-1 ... 1 distinct variations
    // Given [ 1, 2, 3, 4 ], k = 2 - > (1,2),(2,3),(3,4), (1), (2), (3), (4)
    // with k = 1 -> (1), (2), (3), (4)
    private int subarraysWithAtMostKDistinct(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int result = 0;
        for (int r = 0, l = 0; r < nums.length; ++r) {
            frequencies.merge(nums[r], 1, Integer::sum);
            while (frequencies.size() > k) {
                int key = nums[l++];
                if (frequencies.get(key) == 1) {
                    frequencies.remove(key);
                } else {
                    frequencies.merge(key, -1, Integer::sum);
                }
            }
            result += r - l + 1;
        }
        return result;
    }
}