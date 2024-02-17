package com.tulesaza.longestsubstringwithoutrepeatingcharacters;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> lastOccurrence = new HashMap<>();
        int result = 0;
        int startIndex = 0;

        for(int endIndex = 0; endIndex < s.length(); endIndex++) {

            char current = s.charAt(endIndex);

            if(lastOccurrence.containsKey(current)) {
                startIndex = Math.max(startIndex, lastOccurrence.get(current) + 1);
            }

            lastOccurrence.put(current, endIndex);
            result = Math.max(result, endIndex-startIndex + 1);
        }
        return result;
    }
}