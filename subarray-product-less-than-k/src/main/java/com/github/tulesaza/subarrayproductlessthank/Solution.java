package com.github.tulesaza.subarrayproductlessthank;

class Solution {
    /*
     * Sliding window approach
     * Time O(n), space O(1), type overflow should never happen, max nums[i] = 3 * 10^4,
     * max k = 10^6, so maxProduct can be 9*10^8 until window is shrink from the left.
     * Example: nums = [10,5,2,6], k = 100
     * 1) window 1 [10], 1 variant
     * 2) window 2 [10, 5], 2 variants: [(10,5), (5)]
     * 3) window 3 [5, 2], 2 variants: [(5,2), (2)]
     * 4) window 4 [5, 2, 6], 3 variants: [(5,2,6), (2,6), (6)]
     * Inside window count of variants is sum of arithmetic series Sn=(n^2 + n)/2, where n is count of elements,
     * but it includes shorter by 1 right element count of variants Sn-1=((n-1)^2 + (n-1)) / 2
     * so count of unique variants is Sn-Sn-1 = n.
     *
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int n = nums.length, windowProduct = 1, subArraysCount = 0, left = 0;
        for (int right = 0; right < n; ++right) {
            windowProduct *= nums[right];
            while (left <= right && windowProduct >= k) {
                windowProduct /= nums[left++];
            }
            subArraysCount += right - left + 1;
        }
        return subArraysCount;
    }
}
