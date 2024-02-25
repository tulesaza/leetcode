package com.github.tulesaza.removelettertoequalizefrequency;

class Solution {
    public boolean equalFrequency(String word) {
        int[] letterFrequency = new int[26];
        for (char c : word.toCharArray()) {
            letterFrequency[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (letterFrequency[i] > 0) {
                letterFrequency[i]--;
                boolean equalFrequency = true;
                int prevFrequency = 0;
                for (int currentFrequency : letterFrequency) {
                    if (currentFrequency == 0) {
                        continue;
                    }
                    if (prevFrequency > 0 && currentFrequency != prevFrequency) {
                        equalFrequency = false;
                        break;
                    }
                    prevFrequency = currentFrequency;
                }
                if (equalFrequency) {
                    return true;
                }
                letterFrequency[i]++;
            }
        }
        return false;
    }
}
