package com.github.tulesaza.binarysubarrayswithsum;

class Solution {

    // 1. Bruteforce O(n^2)
    // 2. two sliding windows O(n)
    // 3. Prefix sum counts
    public int numSubarraysWithSum(int[] nums, int goal) {
        int goalWindowLeft = 0, goalMinusOneWindowLeft = 0;
        int goalWindowSum = 0; // window where sum equals goal
        int goalMinusOneWindowSum = 0; // window where sum is goal-1, because only 1,0 in array
        int diffs = 0;
        for (int right = 0; right < nums.length; ++right) {
            goalWindowSum += nums[right];
            goalMinusOneWindowSum += nums[right];
            while (goalWindowLeft <= right && goalWindowSum > goal) {
                goalWindowSum -= nums[goalWindowLeft++];
            }
            while (goalMinusOneWindowLeft <= right && goalMinusOneWindowSum > goal - 1) {
                goalMinusOneWindowSum -= nums[goalMinusOneWindowLeft++];
            }
            // count of zeros between window borders, so each zero can be included to wider window
            diffs += goalMinusOneWindowLeft - goalWindowLeft;
        }
        return diffs;
    }

    // Not mine, hard to understand
    // [ 1 0 1 0 1 ] n = 5, max sum 5
    //   0 1 2 3 4 5
    //  [1 2 2 1 0 0 ]
    //
    public int numSubarraysWithSum1(int[] nums, int goal) {
        int totalCount = 0;
        int sum = 0;
        int[] prefixSumCounts = new int[nums.length + 1];
        prefixSumCounts[0] = 1;

        for (int num : nums) {
            sum += num;
            if (sum >= goal) {
                totalCount += prefixSumCounts[sum - goal];
            }
            prefixSumCounts[sum]++;
        }

        return totalCount;
    }
}