package com.tulesaza.minimumwindowsubstring;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private final static int MAX_LEN = 100001;

    /*
     * Since there is only one and unique solution, we can use two pointers
     */
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> charFrequencyT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            charFrequencyT.put(ch, charFrequencyT.getOrDefault(ch, 0) + 1);
        }

        int minWindowLength = MAX_LEN;
        int currentStartS = 0;
        int minStartS = 0;
        int charsMatched = 0;

        for (int endS = 0; endS < s.length(); endS++) {

            char ch = s.charAt(endS);
            Integer frequenciesNotMatched = charFrequencyT.get(ch);
            if (frequenciesNotMatched != null) {
                if (frequenciesNotMatched - 1 >= 0) {
                    charsMatched++;
                }
                charFrequencyT.put(ch, frequenciesNotMatched - 1);

            }

            while (charsMatched == t.length()) {

                int currentWindowLength = endS - currentStartS + 1;
                if (currentWindowLength < minWindowLength) {
                    minStartS = currentStartS;
                    minWindowLength = currentWindowLength;
                }

                char toShrink = s.charAt(currentStartS);
                Integer freq = charFrequencyT.get(toShrink);

                if (freq != null) {
                    if (freq == 0) {
                        charsMatched--;
                    }

                    charFrequencyT.put(toShrink, freq + 1);

                }
                currentStartS++;
            }

        }

        if (minWindowLength == MAX_LEN) {
            return "";
        }

        return s.substring(minStartS, minStartS + minWindowLength);


    }


}