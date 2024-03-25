package com.github.tulesaza.maxnumberofksumpairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    /*
     * 1. Sort and go with two pointers O(n*log(n)), space O(1)
     */
    public int maxOperations1(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, count = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                left++;
                right--;
                count++;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    /*
     * 2. Store nums frequency in map/table, O(n), space O(n)
     */
    public int maxOperations2(int[] nums, int k) {
        Map<Integer, Integer> numFrequency = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int pair = k - num;
            if (numFrequency.containsKey(pair) && numFrequency.get(pair) > 0) {
                numFrequency.put(pair, numFrequency.get(pair) - 1);
                count++;
                continue;
            }
            if (numFrequency.containsKey(num)) {
                numFrequency.put(num, numFrequency.get(num) + 1);
            } else {
                numFrequency.put(num, 1);
            }
        }
        return count;
    }
}