package com.github.tulesaza.firstmissingpositive;

class Solution {

    /*
     * Let length of nums be n, so the smallest positive missing integer should within range 1 to n,
     * in case when all sequence is complete - n + 1. That means we can use input array as hash
     * table, if number k from range [1;n] presents put it to k-1 position. Then we can check array again
     * and find where last number of increasing from 1 to t sequence and result will t + 1;
     * Time O(n), space O(1)
     * Example: [3,4,-1,1]
     * Filling table:
     * 1) [-1,4,3,1]
     * 2) [-1,1,3,4]
     * 3) [1,-1,3,4]
     * Checking array [1,-1,3,4], t = 1, result 2.
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int index = 0;
        while (index < n) {
            int hash = nums[index] - 1;
            if (hash < n && hash >= 0 && nums[hash] != nums[index]) {
                int temp = nums[hash];
                nums[hash] = nums[index];
                nums[index] = temp;
            } else {
                index++;
            }
        }
        //System.out.println("After hashing: " + Arrays.toString(nums));
        int result = n + 1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                result = i + 1;
                break;
            }
        }
        return result;
    }
}