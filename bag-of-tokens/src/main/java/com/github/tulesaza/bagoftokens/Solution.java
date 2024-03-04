package com.github.tulesaza.bagoftokens;

import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if (tokens.length == 0) return 0;
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1, score = 0;
        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                score++;
                left++;
            } else if (score > 0 && right - left > 1) {
                power += tokens[right];
                score--;
                right--;
            } else {
                break;
            }
        }
        return score;
    }
}