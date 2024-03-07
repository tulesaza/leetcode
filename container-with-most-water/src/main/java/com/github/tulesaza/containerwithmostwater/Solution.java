package com.github.tulesaza.containerwithmostwater;

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxAmount = 0;
        while (left < right) {
            int amount = Math.min(height[left], height[right]) * (right - left);
            maxAmount = Math.max(maxAmount, amount);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxAmount;
    }
}