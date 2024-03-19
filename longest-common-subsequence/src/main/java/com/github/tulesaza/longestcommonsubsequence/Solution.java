package com.github.tulesaza.longestcommonsubsequence;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] maxSubsequence = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < m + 1; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    maxSubsequence[i][j] = 1 + maxSubsequence[i - 1][j - 1];
                } else {
                    maxSubsequence[i][j] = Math.max(maxSubsequence[i - 1][j], maxSubsequence[i][j - 1]);
                }
            }
        }
        return maxSubsequence[n][m];
    }
}