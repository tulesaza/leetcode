package com.github.tulesaza.trappingrainwater;

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int water = 0;
        int rightBorderHeight = height[right];
        int lefBorderHeight = height[left];
        // water can be trapped min height (left, right) * dist(left,right) - sum heights between(left, right)
        while (left < right) {
            if (height[right] > height[left]) {
                lefBorderHeight = Math.max(lefBorderHeight, height[left]);
                water += lefBorderHeight - height[left];
                left++;
            } else {
                rightBorderHeight = Math.max(rightBorderHeight, height[right]);
                water += rightBorderHeight - height[right];
                right--;
            }
        }

        return water;
    }
}