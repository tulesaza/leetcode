package com.github.tulesaza.houserobber;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) return nums[0];
        int[] maximumRob = new int[n + 1];
        maximumRob[1] = nums[0];
        for (int i = 2; i <= n; ++i) {
            maximumRob[i] = Math.max(nums[i - 1] + maximumRob[i - 2], maximumRob[i - 1]);
        }
        return maximumRob[n];
    }
}
