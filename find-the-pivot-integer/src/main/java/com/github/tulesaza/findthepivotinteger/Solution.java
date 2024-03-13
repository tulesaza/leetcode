package com.github.tulesaza.findthepivotinteger;

class Solution {

    // O(log(N))
    // [1...k-1,k,k+1...n]
    // [1....k] = [k...n] -> (1 + k)*k/2 = (n + k)*(n - k + 1) / 2 -> k = sqrt((n+n^2)/2)
    public int pivotInteger(int n) {
        if (n == 1) return 1;

        int sum = n * (n + 1) / 2;
        // Could be O(1) with built-in sqrt:
        // int k = (int)Math.sqrt(sum)
        // return k * k == sum ? return k : -1

        // binary search looks cooler
        int low = 1, high = n;
        while (low < high) {
            int k = low + (high - low) / 2;
            int kPow2 = k * k;
            if (kPow2 == sum) {
                return k;
            } else if (kPow2 > sum) {
                high = k - 1;
            } else {
                low = k + 1;
            }
        }
        return -1;
    }
}
