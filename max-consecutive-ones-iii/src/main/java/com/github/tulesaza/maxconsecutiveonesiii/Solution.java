package com.github.tulesaza.maxconsecutiveonesiii;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0, left = 0, maxOnes = 0;
        for (int right = 0; right < nums.length; ++right) {
            if (nums[right] == 0) zeros++;
            while (zeros > k) {
                if (nums[left++] == 0) zeros--;
            }
            maxOnes = Math.max(maxOnes, right - left + 1);
        }
        return maxOnes;
    }
}