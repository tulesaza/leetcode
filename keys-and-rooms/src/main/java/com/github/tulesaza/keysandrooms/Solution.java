package com.github.tulesaza.keysandrooms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();
            if (visited.contains(currentRoom)) {
                continue;
            }
            for (int key : rooms.get(currentRoom)) {
                queue.offer(key);
            }
            visited.add(currentRoom);
        }
        return visited.size() == n;
    }
}