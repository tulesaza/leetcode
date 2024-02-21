package com.github.tulesaza.bitwiseandofnumberrange;

public class Solution {

    // Calculate difference in bit and make new number with trailing zeros
    public int rangeBitwiseAnd2(int left, int right) {
        int difference = 0;
        // shift right until nums the same
        while (left != right) {
            left >>= 1;
            right >>= 1;
            difference++;
        }
        // shift left common part several times to have zeros on the right
        return (left << difference);
    }

    // straight forward
    public int rangeBitwiseAnd1(int left, int right) {
        while (left < right) {
            right = (right - 1) & right;
        }
        return left & right;
    }
}
