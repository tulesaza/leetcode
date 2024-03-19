package com.github.tulesaza.equalrowandcolumnpairs;

import java.util.HashMap;
import java.util.Map;

class Solution {
    /*
     *  3 1 2 2
     *  1 4 4 5
     *  2 4 2 2
     *  2 4 2 2
     */
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> row2Count = new HashMap<>();
        Map<String, Integer> column2Count = new HashMap<>();
        for (int[] row : grid) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(row[i]);
                sb.append("|");
            }
            String rowHash = sb.toString();
            row2Count.put(rowHash, row2Count.getOrDefault(rowHash, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            StringBuilder column = new StringBuilder();
            for (int[] row : grid) {
                column.append(row[i]);
                column.append("|");
            }
            String columnHash = column.toString();
            column2Count.put(columnHash, column2Count.getOrDefault(columnHash, 0) + 1);
        }

        int result = 0;
        for (var rowAndCount : row2Count.entrySet()) {
            result += rowAndCount.getValue() * column2Count.getOrDefault(rowAndCount.getKey(), 0);
        }

        return result;
    }
}