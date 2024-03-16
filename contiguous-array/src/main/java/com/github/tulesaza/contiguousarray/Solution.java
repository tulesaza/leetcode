package com.github.tulesaza.contiguousarray;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // Time - O(n), Space - O(n)
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        // memorize lower index if prefix sum is equal
        Map<Integer, Integer> prefixSum2LowerIndex = new HashMap<>();
        prefixSum2LowerIndex.put(0, -1); // fake -1 index
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += (nums[i] == 0 ? -1 : 1);
            Integer existingIndex = prefixSum2LowerIndex.get(sum);
            if (existingIndex != null) {
                maxLength = Math.max(maxLength, i - existingIndex);
            } else {
                prefixSum2LowerIndex.put(sum, i);
            }
        }
        return maxLength;
    }
}
