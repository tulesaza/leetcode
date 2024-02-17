package com.tulesaza.findallanagramsinastring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int[] charFrequencyP = new int[26];
        int windowLenght = p.length();
        for (int i = 0; i < windowLenght; i++) {
            charFrequencyP[getIndex(p.charAt(i))]++;
        }


        int[] charFrequencyS = new int[26];
        int charCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            charCounter++;
            charFrequencyS[getIndex(s.charAt(i))]++;
            if (charCounter == windowLenght) {
                int startIndex = i - windowLenght + 1;
                if (Arrays.equals(charFrequencyP, charFrequencyS)) {
                    result.add(startIndex);
                }
                charFrequencyS[getIndex(s.charAt(startIndex))]--;
                charCounter--;

            }

        }


        return result;
    }

    private int getIndex(char ch) {
        return (int) ch - 'a';

    }
}