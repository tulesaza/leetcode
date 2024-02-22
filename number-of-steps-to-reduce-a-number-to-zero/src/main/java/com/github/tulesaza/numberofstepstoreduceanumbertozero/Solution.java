package com.github.tulesaza.numberofstepstoreduceanumbertozero;

class Solution {

    // each >>1 (divide by 2) ones count remains the same, but bits length decreased by 1
    // each  -1 (setting up least significant bit to 0) bits length is the same and bits count decreased by 1
    // 0) 14 -> 1110 (14)   (length 4, ones 3)
    // 1)  7 ->  111 (14/2) (length 3, ones 3)
    // 2)  6 ->  110 (7-1)  (length 3, ones 2)
    // 3)  3 ->   11 (6/2)  (length 2, ones 2)
    // 4)  2 ->   10 (3-1)  (length 2, ones 1)
    // 5)  1 ->    1 (2/1)  (length 1, ones 1)
    // 6)  0 ->    0 (1-1)  (length 0, ones 0)
    // time O(1) and space O(1)
    public int numberOfSteps(int num) {
        if (num == 0) return 0;
        int bitsLength = 32 - Integer.numberOfLeadingZeros(num);
        int onesCount = Integer.bitCount(num);
        return bitsLength + onesCount - 1;
    }
}