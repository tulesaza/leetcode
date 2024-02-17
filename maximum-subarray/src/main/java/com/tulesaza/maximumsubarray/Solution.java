package com.tulesaza.maximumsubarray;

class Solution {
    public static int MIN_BOUNDARY = -10000;

    public int maxSubArray(int[] nums) {
        int maxSoFar = MIN_BOUNDARY - 1;
        int absoluteMax = MIN_BOUNDARY - 1;
        for (int num : nums) {
            maxSoFar = Math.max(num, maxSoFar + num);
            absoluteMax = Math.max(absoluteMax, maxSoFar);
        }

        return absoluteMax;
    }
}