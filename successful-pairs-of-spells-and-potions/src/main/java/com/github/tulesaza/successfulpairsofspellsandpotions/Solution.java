package com.github.tulesaza.successfulpairsofspellsandpotions;


import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            result[i] = searchSucceedPotionCount(spells[i], potions, success);
        }

        return result;
    }

    private int searchSucceedPotionCount(int spell, int[] potions, long success) {
        int low = 0, high = potions.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long spelledMid = (long) spell * potions[mid];
            long spelledPrev = mid > 0 ? (long) spell * potions[mid - 1] : -1;
            if (spelledMid >= success && spelledPrev < success) {
                return potions.length - mid;
            } else if (spelledPrev >= success) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
}