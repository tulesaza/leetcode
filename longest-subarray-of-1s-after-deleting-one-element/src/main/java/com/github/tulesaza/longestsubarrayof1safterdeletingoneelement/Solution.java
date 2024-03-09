package com.github.tulesaza.longestsubarrayof1safterdeletingoneelement;

class Solution {
    public int longestSubarray(int[] nums) {
        int leftBorderIncl = 0, zerosCount = 0, longestWindow = 0;
        // extend window counting zeros
        for (int rightBorderIncl = 0; rightBorderIncl < nums.length; rightBorderIncl++) {
            if (nums[rightBorderIncl] == 0) {
                zerosCount++;
            }
            // if zeros is more than 1, shrink window from the left
            while (zerosCount > 1 && leftBorderIncl < rightBorderIncl) {
                if (nums[leftBorderIncl] == 0) {
                    zerosCount--;
                }
                leftBorderIncl++;
            }
            // without +1 because, one element should be removed
            longestWindow = Math.max(longestWindow, rightBorderIncl - leftBorderIncl);
        }
        return longestWindow;
    }
}