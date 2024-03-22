package com.github.tulesaza.editdistance;


class Solution {
    /*
    *   Given horse, ros
    *
    *   0 h o r s e
    * 0 0 1 2 3 4 5
    * r 1 1 2 2 3 4
    * o 2 2 1 2 3 4
    * s 3 3 2 2 2 3
    *
    */
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] distance = new int[n + 1][m + 1];
        for (int j = 1; j <= m; j++) {
            distance[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            distance[i][0] = i;
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = 1 + Math.min(Math.min(distance[i - 1][j], distance[i][j - 1]),
                                                  distance[i - 1][j - 1]);
                }
            }
        }
        return distance[n][m];
    }
}