package com.github.tulesaza.findpivotindex;

import java.util.stream.IntStream;

class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0, rightSum = IntStream.of(nums).sum();
        for (int i = 0; i < nums.length; ++i) {
            leftSum += (i > 0 ? nums[i - 1] : 0);
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
