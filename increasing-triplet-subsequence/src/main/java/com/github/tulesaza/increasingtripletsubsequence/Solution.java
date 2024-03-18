package com.github.tulesaza.increasingtripletsubsequence;

class Solution {
    // low < mid < high
    public boolean increasingTriplet(int[] nums) {
        int low = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (mid < num) {
                return true;
            } else if (num <= low) {
                low = num;
            } else {
                mid = num;
            }
        }
        return false;
    }
}