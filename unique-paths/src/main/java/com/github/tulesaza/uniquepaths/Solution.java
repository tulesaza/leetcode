package com.github.tulesaza.uniquepaths;

class Solution {

    /*  m - rows, n - columns
     *     0 1 2 3 4 5 6
     *     _____________
     *  0 |1 1 1 1 1 1 1|
     *  1 |1 2 3 4 5 6 7|
     *  2 |1 3 6 10 ... |
     *  3 |1 4 10 ..... |
     */
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int row = 0; row < m; ++row) {
            for (int column = 0; column < n; ++column) {
                if (row == 0) {
                    grid[row][column] = 1;
                } else if (column == 0) {
                    grid[row][column] = 1;
                } else {
                    grid[row][column] = grid[row - 1][column] + grid[row][column - 1];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}