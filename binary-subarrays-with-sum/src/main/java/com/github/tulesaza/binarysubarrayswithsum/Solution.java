package com.github.tulesaza.binarysubarrayswithsum;

class Solution {

    // 1. Bruteforce O(n^2)
    // 2. two sliding windows O(n)
    public int numSubarraysWithSum(int[] nums, int goal) {
        int goalWindowLeft = 0, goalMinusOneWindowLeft = 0, right = 0;
        int goalWindowSum = 0; // window where sum equals goal
        int goalMinusOneWindowSum = 0; // window where sum is goal-1, because only 1,0 in array
        int diffs = 0;
        while (right < nums.length) {
            goalWindowSum += nums[right];
            goalMinusOneWindowSum += nums[right];
            while (goalWindowLeft <= right && goalWindowSum > goal) {
                goalWindowSum -= nums[goalWindowLeft++];
            }
            while (goalMinusOneWindowLeft <= right && goalMinusOneWindowSum > goal - 1) {
                goalMinusOneWindowSum -= nums[goalMinusOneWindowLeft++];
            }
            diffs += goalMinusOneWindowLeft - goalWindowLeft; // count of zeros between window borders, so each zero can be
            // included to wider window
            ++right;
        }
        return diffs;
    }
}