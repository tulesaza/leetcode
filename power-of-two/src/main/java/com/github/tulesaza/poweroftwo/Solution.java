package com.github.tulesaza.poweroftwo;

class Solution {
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}