package com.tulesaza.permutationinstring;

import java.util.Arrays;

class Solution {

    public boolean checkInclusion(String s1, String s2) {
        int[] charFrequency1 = new int[26];
        int windowLength = s1.length();
        for (int i = 0; i < windowLength; i++) {
            int index = getIndex(s1.charAt(i));
            charFrequency1[index]++;
        }


        int[] charFrequency2 = new int[26];
        int charCounter = 0;
        for (int i = 0; i < s2.length(); i++) {
            charCounter++;
            charFrequency2[getIndex(s2.charAt(i))]++;
            if (charCounter == windowLength) {
                if (Arrays.equals(charFrequency1, charFrequency2)) {
                    return true;
                } else {
                    charFrequency2[getIndex(s2.charAt(i - windowLength + 1))]--;
                    charCounter--;
                }

            }

        }


        return false;

    }

    private int getIndex(char ch) {
        return (int) ch - 'a';

    }
}
