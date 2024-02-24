package com.github.tulesaza.findallpeoplewithsecret;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class Solution {
    // TODO: union-find data structure should be faster
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        SortedMap<Integer, LinkedList<Pair>> timesOfMeetings = new TreeMap<>(Comparator.naturalOrder());
        // parse by time frame
        for (var meeting : meetings) {
            timesOfMeetings.computeIfAbsent(meeting[2], key -> new LinkedList<>()).add(Pair.from(meeting));
        }
        var peopleKnowingSecret = new HashSet<Integer>();
        peopleKnowingSecret.add(0);
        peopleKnowingSecret.add(firstPerson);

        for (var timeSlot : timesOfMeetings.entrySet()) {
            // run bfs for graph
            var pairs = timeSlot.getValue();
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> uniquePeople = new HashSet<>();
            for (var pair : pairs) {
                graph.computeIfAbsent(pair.x(), key -> new ArrayList<>()).add(pair.y());
                graph.computeIfAbsent(pair.y(), key -> new ArrayList<>()).add(pair.x());
                uniquePeople.add(pair.x());
                uniquePeople.add(pair.y());
            }
            Deque<Integer> queue = new ArrayDeque<>();
            for (int people : uniquePeople) {
                if (peopleKnowingSecret.contains(people)) {
                    queue.offer(people);
                }
            }
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int neighbor : graph.getOrDefault(current, Collections.emptyList())) {
                    if (!peopleKnowingSecret.contains(neighbor)) {
                        peopleKnowingSecret.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return peopleKnowingSecret.stream().toList();
    }

    record Pair(int x, int y) {
        static Pair from(int[] meeting) {
            return new Pair(meeting[0], meeting[1]);
        }
    }
}