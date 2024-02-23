package com.github.tulesaza.numberof1bits;

public class Solution {
    // you need to treat n as an unsigned value
    // Given, n = 7, 0111, onesCount = 0,
    // 0111 & 0001 = 1, onesCount = 1, 0111 -> 0011
    // 0011 & 0001 = 1, onesCount = 2, 0011 -> 0001
    // 0001 & 0001 = 1, onesCount = 3, 0001 -> 0000
    public int hammingWeight(int n) {
        int maskLeastSignificantBit = 0x01;
        int onesCount = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & maskLeastSignificantBit) == 1) { // checks if last bit in n is 1
                onesCount++;
            }
            n >>= 1; // shift right
            if (n == 0) {
                break;
            }
        }
        return onesCount;
    }

    public int buildInHammingWeigh(int n) {
        return Integer.bitCount(n);
    }
}
