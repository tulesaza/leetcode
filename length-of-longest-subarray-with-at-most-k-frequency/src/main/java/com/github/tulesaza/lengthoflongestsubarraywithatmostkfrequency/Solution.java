package com.github.tulesaza.lengthoflongestsubarraywithatmostkfrequency;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxSubArray = 0;
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int right = 0, left = 0; right < nums.length; right++) {
            //frequency.put(nums[right], frequency.getOrDefault(nums[right], 0) + 1);
            frequency.merge(nums[right], 1, Integer::sum);
            while (left < right && frequency.get(nums[right]) > k) {
                //frequency.put(nums[left], frequency.get(nums[left]) - 1);
                //left++;
                frequency.merge(nums[left++], -1, Integer::sum);
            }
            maxSubArray = Math.max(maxSubArray, right - left + 1);
        }
        return maxSubArray;
    }
}