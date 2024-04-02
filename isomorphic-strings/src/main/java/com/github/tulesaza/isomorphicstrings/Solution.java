package com.github.tulesaza.isomorphicstrings;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sTranslate = new int[256];
        int[] tTranslate = new int[256];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int sInt = s.charAt(i), tInt = t.charAt(i);
            if (sTranslate[sInt] != tTranslate[tInt]) {
                return false;
            }
            sTranslate[sInt] = i + 1;
            tTranslate[tInt] = i + 1;
        }
        return true;
    }
}