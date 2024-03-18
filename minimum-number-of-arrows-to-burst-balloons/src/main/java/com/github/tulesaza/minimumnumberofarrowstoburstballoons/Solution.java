package com.github.tulesaza.minimumnumberofarrowstoburstballoons;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    // Sort O(n*log(n)), O(1)
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) return 1;
        int number = 1;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int prevStart = points[0][0], prevEnd = points[0][1];
        for (int[] point : points) {
            int start = point[0], end = point[1];
            if ((start >= prevStart && start <= prevEnd)) {
                prevStart = start;
                prevEnd = Math.min(end, prevEnd);
            } else {
                number++;
                prevStart = start;
                prevEnd = end;
            }
        }
        return number;
    }
}