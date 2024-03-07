package com.github.tulesaza.canplaceflowers;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            int leftNeighbor = i == 0 ? 0 : flowerbed[i - 1];
            int rightNeighbor = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            if (leftNeighbor + flowerbed[i] + rightNeighbor == 0) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return n == 0;
    }
}