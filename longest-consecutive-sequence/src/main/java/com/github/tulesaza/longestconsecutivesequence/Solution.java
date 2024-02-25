package com.github.tulesaza.longestconsecutivesequence;

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int longestConsecutive(int[] nums) {
        var uniqueNums = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int result = 0;
        for (int num : uniqueNums) {
            if (!uniqueNums.contains(num - 1)) {
                int next = num + 1;
                while (uniqueNums.contains(next)) {
                    next++;
                }
                result = Math.max(result, next - num);
            }
        }

        return result;
    }
}