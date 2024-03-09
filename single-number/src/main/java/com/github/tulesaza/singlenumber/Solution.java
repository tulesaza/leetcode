package com.github.tulesaza.singlenumber;


class Solution {
    /*
     * 1. sorting  time O(n*log(n)), space O(1) - NO
     * 2. extra set time O(n) space O(n) - NO
     * 3. XOR, time O(n) space O(1) -> X xor 0 = X, X xor X = 0;
     *
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}