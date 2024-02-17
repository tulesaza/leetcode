package com.tulesaza.maxprofit;

class Solution {
    private final static int ABSOLUTE_MAX_PRICE = 10000;

    public int maxProfit(int[] prices) {
        int minimalPrice = ABSOLUTE_MAX_PRICE + 1;
        int maxProfit = 0;
        for (int price : prices) {
            minimalPrice = Math.min(minimalPrice, price);
            maxProfit = Math.max(maxProfit, price - minimalPrice);

        }
        return maxProfit;

    }
}