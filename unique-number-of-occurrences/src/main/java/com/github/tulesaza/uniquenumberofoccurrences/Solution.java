package com.github.tulesaza.uniquenumberofoccurrences;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Long> num2Count = Arrays.stream(arr)
                .boxed()
                .collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int occurrences = num2Count.size();

        return num2Count.values().stream().distinct().count() == occurrences;
    }
}