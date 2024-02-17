package com.tulesaza.maxprofit2;

class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int margin = prices[i + 1] - prices[i];
            if (margin > 0) {
                result += margin;
            }
        }
        return result;

    }
}