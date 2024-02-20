package com.github.tulesaza.numberofchangingkeys;

import java.util.Locale;

class Solution {
    public int countKeyChanges(String s) {
        String lowered = s.toLowerCase(Locale.ROOT);
        int counter = 0;
        char prev = lowered.charAt(0);
        for (char c : lowered.toCharArray()) {
            if (c != prev) {
                counter++;
                prev = c;
            }
        }
        return counter;
    }
}
