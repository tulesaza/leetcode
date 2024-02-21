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

    public int trapCoolHackerStyle(int[] h) {
        int left = 0, right = h.length - 1;
        int water = 0;
        int rightBorderHeight = h[right];
        int lefBorderHeight = h[left];

        while (left < right) {
            lefBorderHeight = Math.max(lefBorderHeight, h[left]);
            rightBorderHeight = Math.max(rightBorderHeight, h[right]);
            water += h[right] > h[left] ? lefBorderHeight - h[left++] : rightBorderHeight - h[right--];
        }

        return water;
    }
}