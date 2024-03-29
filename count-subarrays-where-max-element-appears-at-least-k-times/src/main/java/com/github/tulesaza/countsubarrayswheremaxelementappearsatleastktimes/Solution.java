package com.github.tulesaza.countsubarrayswheremaxelementappearsatleastktimes;

import java.util.Arrays;

class Solution {

    // Extend window until
    public long countSubarrays1(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int maxCount = 0, n = nums.length;
        long result = 0;
        for (int right = 0, left = 0; left < n; left++) {
            while (right < n && maxCount < k) {
                maxCount += nums[right++] == max ? 1 : 0;
            }
            if (maxCount < k) {
                break;
            }
            result += n - right + 1;
            maxCount -= nums[left] == max ? 1 : 0;
        }
        return result;
    }

    public long countSubarrays2(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int maxCount = 0;
        long result = 0;
        for (int right = 0, left = 0; right < nums.length; right++) {
            if (nums[right] == max) maxCount++;
            while (maxCount >= k) {
                if (nums[left++] == max) maxCount--;
            }
            result += left;
        }
        return result;
    }
}