package com.github.tulesaza.determineiftwostringsareclose;

import java.util.Arrays;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] table1 = new int[26];
        int[] table2 = new int[26];
        for (char c : word1.toCharArray()) {
            table1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            table2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (table1[i] == 0 ^ table2[i] == 0) {
                return false;
            }
        }

        Arrays.sort(table1);
        Arrays.sort(table2);
        return Arrays.equals(table1, table2);
    }
}