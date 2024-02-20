package com.github.tulesaza.missingnumber;

class Solution {
    public int missingNumber(int[] nums) {
        int sumOfProgression = (nums.length) * (nums.length + 1) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sumOfProgression - sum;
    }
}