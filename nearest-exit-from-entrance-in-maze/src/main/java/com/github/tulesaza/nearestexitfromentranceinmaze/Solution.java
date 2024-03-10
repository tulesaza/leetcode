package com.github.tulesaza.nearestexitfromentranceinmaze;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int columns = maze[0].length;
        int steps = 0;
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = 'X';
        while (!queue.isEmpty()) {
            steps++;
            for (int i = queue.size(); i > 0; i--) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int[] next : List.of(new int[]{x - 1, y}, new int[]{x, y - 1}, new int[]{x + 1, y},
                                          new int[]{x, y + 1})) {
                    int nextX = next[0], nextY = next[1];
                    if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < columns && maze[nextX][nextY] == '.') {
                        if (nextX == 0 || nextY == 0 || nextX == rows - 1 || nextY == columns - 1) {
                            return steps;
                        }
                        queue.offer(next);
                        maze[nextX][nextY] = 'X';
                    }
                }
            }
        }
        return -1;
    }

}