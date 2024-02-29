package com.github.tulesaza.movezeroes;

class Solution {
    public void moveZeroes(int[] nums) {
        int nextIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nextIndex++;
                int temp = nums[nextIndex];
                nums[nextIndex] = nums[i];
                nums[i] = temp;
            }
        }
    }
}