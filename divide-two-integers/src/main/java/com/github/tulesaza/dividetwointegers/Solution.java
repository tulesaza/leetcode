package com.github.tulesaza.dividetwointegers;

class Solution {
    // multiplication, division, and mod operator are not allowed, no 64 bit types ;)
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend > 0) ^ (divisor > 0); // XOR, different signs -> negative
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        // dividend =  divisor * (2^k+2^l+..2^m) + r,  where r < divisor
        // 116 = 3 * 2^5 + 20
        //  20 = 3 * 2^2 + 8
        //   8 = 3 * 2^1 + 2
        //   2<3
        // So 116 = 3*2^5 + 3*2^2 + 3*2 + 2
        // 116 = 3(2^5+2^2+2) + 2
        // 116/3 = sumOf2Powers + 2/3 (<1, will be cut because of int division)
        int reminder = dividend, sumOf2Powers = 0, power;
        while (reminder - divisor >= 0) {
            for (power = 0; reminder - (divisor << 1 << power) >= 0; power++) ; // find 2^k, so reminder >= divisor*2^k
            sumOf2Powers += 1 << power; // accomulate
            reminder -= divisor << power;
        }

        return isNegative ? -sumOf2Powers : sumOf2Powers;
    }
}