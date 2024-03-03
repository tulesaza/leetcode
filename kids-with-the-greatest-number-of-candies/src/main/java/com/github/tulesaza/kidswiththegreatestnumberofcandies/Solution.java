package com.github.tulesaza.kidswiththegreatestnumberofcandies;

import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).boxed().map(c -> c + extraCandies >= max).toList();
    }
}