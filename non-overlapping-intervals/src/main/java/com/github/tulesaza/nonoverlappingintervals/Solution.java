package com.github.tulesaza.nonoverlappingintervals;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[1]));
        int removedCount = 0;
        int currentBoundary = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] >= currentBoundary) {
                currentBoundary = intervals[i][1];
            } else {
                removedCount++;
            }

        }

        return removedCount;
    }
}