package com.github.tulesaza.insertinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {

    // Straight forward O(n) solution
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int newStart = newInterval[0], newEnd = newInterval[1];
        boolean inserted = false;
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            // before
            if (newEnd < start) {
                if (!inserted) {
                    result.add(new int[] {newStart, newEnd});
                    inserted = true;
                }
                result.add(interval);
            // after
            } else if (end < newStart) {
                result.add(interval);
            // merge
            } else {
                newStart = Math.min(newStart, start);
                newEnd = Math.max(newEnd, end);
            }
        }
        if (!inserted) {
            result.add(new int[] {newStart, newEnd});
        }
        return result.toArray(new int[result.size()][]);
    }

    // Binary search indexes of arrays, O(n) in worst cases, O(logN) in better
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int newStart = newInterval[0], newEnd = newInterval[1];
        int leftBoundary = binarySearchBoundary(intervals, newStart, Comparator.comparingInt(a -> a[1]));
        if (leftBoundary < n && intervals[leftBoundary][0] < newStart) {
            newStart = intervals[leftBoundary][0]; // merged
        }
        int rightBoundary = binarySearchBoundary(intervals, newEnd, Comparator.comparingInt(a -> a[0]));
        // find before but can be inside, check previous which is exactly before first
        if (rightBoundary <= n && rightBoundary > 0 && intervals[rightBoundary - 1][1] > newEnd) {
            newEnd = intervals[rightBoundary - 1][1];
        }
        // if after has the same border
        if (rightBoundary < n && newEnd == intervals[rightBoundary][0]) {
            newEnd = intervals[rightBoundary][1];
            rightBoundary++;
        }
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < leftBoundary; i++) {
            merged.add(intervals[i]);
        }
        merged.add(new int[]{newStart, newEnd});
        for (int i = rightBoundary; i < n; i++) {
            merged.add(intervals[i]);
        }
        return merged.toArray(new int[merged.size()][]);
    }

    private static int binarySearchBoundary(int[][] intervals, int boundary, Comparator<int[]> comp) {
        int result = Arrays.binarySearch(intervals, new int[]{boundary, boundary}, comp);
        return result < 0 ? Math.abs(result) - 1 : result;
    }
}