package com.github.tulesaza.squaresofasortedarray;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1, rIndex = n - 1;
        while (left <= right) {
            if (nums[right] * nums[right] > nums[left] * nums[left]) {
                result[rIndex] = nums[right] * nums[right];
                right--;
            } else {
                result[rIndex] = nums[left] * nums[left];
                left++;
            }

            rIndex--;
        }

        return result;
    }
}
