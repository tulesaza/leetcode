package com.github.tulesaza.asteroidcollision;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    // O(n) time, O(n) space, stack or queue
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> queue = new ArrayDeque<>(asteroids.length);
        for (int asteroid : asteroids) {
            if (asteroid > 0) { // moving right
                queue.offer(asteroid);
            } else { // moving left
                // destroying others smaller moving right
                while (!queue.isEmpty() && queue.peekLast() > 0 && queue.peekLast() < -asteroid) {
                    queue.pollLast();
                }
                // equal size -> both destroyed
                if (!queue.isEmpty() && queue.peekLast() == -asteroid) {
                    queue.pollLast();
                    // destroyed all or  same direction
                } else if (queue.isEmpty() || queue.peekLast() < 0) {
                    queue.offer(asteroid);
                }
            }
        }

        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}
