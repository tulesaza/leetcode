package com.github.tulesaza.countsubarrayswithfixedbounds;

class Solution {
    /*
     *   [ a0, a1, a2, amin, a3, a4, amax, a5, A0, A1, amin, a6, a7, amax]
     *   ( a0, a1, a2, amin, a3, a4, amax) + (a5) - 2 variant
     *        (a1, a2, amin, a3, a4, amax) + (a5) - 2 variant
     *           ( a2, amin, a3, a4, amax) + (a5) - 2 variant
     *               ( amin, a3, a4, amax) + (a5) - 2 variant
     *    let arr[i] = amin, result+= (i + 1)  for each right boundary amax, a5
     *    Then after out of range A0, A1, we start counting from the very beginning the same as for completely new Array.
     */
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int recentMinIndex = -1, recentMaxIndex = -1, recentOutOfRangeIndex = -1;
        long result = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                recentOutOfRangeIndex = i;
            }
            if (nums[i] == minK) {
                recentMinIndex = i;
            }
            if (nums[i] == maxK) {
                recentMaxIndex = i;
            }
            int boundary = Math.min(recentMinIndex, recentMaxIndex);
            result += Math.max(0, boundary - recentOutOfRangeIndex);
        }
        return result;
    }
}