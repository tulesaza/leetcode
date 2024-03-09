package com.github.tulesaza.minimumflipstomakeaorbequaltoc;

class Solution {
    // since max number is 10^9,  max MSB is 29,  we can compare 29 bits in each number
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for (int shift = 0; shift < 30; shift++) {
            // take just one bit on each iteration
            int aBit = (a >> shift) & 1;
            int bBit = (b >> shift) & 1;
            int cBit = (c >> shift) & 1;
            if ((aBit | bBit) != cBit) { // do OR for taken bits
                if (cBit == 0) {
                    flips += aBit + bBit;
                } else {
                    flips++;
                }

            }
        }
        return flips;
    }
}