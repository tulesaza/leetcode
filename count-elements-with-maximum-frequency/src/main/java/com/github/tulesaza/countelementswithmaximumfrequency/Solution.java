package com.github.tulesaza.countelementswithmaximumfrequency;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> element2frequency = new HashMap<>();
        int maxFrequency = 0;
        int count = 0;
        for (int num : nums) {
            int currentFrequency = element2frequency.getOrDefault(num, 0) + 1;
            element2frequency.put(num, currentFrequency);
            if (currentFrequency > maxFrequency) {
                count = 1;
                maxFrequency = currentFrequency;
            } else if (currentFrequency == maxFrequency) {
                count++;
            }
        }

        return count * maxFrequency;

    }
}