package com.github.tulesaza.countingbits;

class Solution {

    /*  The main idea calculate common part of n and n-1
     *  000 0 -> 0
     *  001 1 -> r[1 & 0] + 1 = r[0] + 1 = 1
     *  010 2 -> r[2 & 1] + 1 = r[0] + 1 = 1
     *  011 3 -> r[3 & 2] + 1 = r[2] + 1 = 2
     *  100 4 -> r[4 & 3] + 1 = r[0] + 1 = 1
     *  101 5 -> r[5 & 4] + 1 = r[1] + 1 = 2
     *  110 6 -> r[6 & 5] + 1 = r[4] + 1 = 2
     *  111 7 -> r[7 & 6] + 1 = r[6] + 1 = 3
     * 1000 8 -> r[8 & 7] + 1 = r[0] + 1 = 1
     */
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            // Integer.bitCount(i) or calculating bit counts by left shift and & 1 much is easier but against requirements
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
}

