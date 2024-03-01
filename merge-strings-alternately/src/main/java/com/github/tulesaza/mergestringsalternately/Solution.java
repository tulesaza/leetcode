package com.github.tulesaza.mergestringsalternately;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        String longerWord = word1.length() > word2.length() ? word1 : word2;
        int i;
        for (i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        sb.append(longerWord.substring(i));
        return sb.toString();
    }
}
