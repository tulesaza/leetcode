package com.github.tulesaza.cheapestflightswithinkstops;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (var flight : flights) {
            var adj = graph.getOrDefault(flight[0], new HashMap<>());
            adj.put(flight[1], flight[2]);
            graph.put(flight[0], adj);
        }
        Deque<int[]> queue = new LinkedList<>(); // arr[0] = city, arr[1] = price
        queue.add(new int[]{src, 0});
        int[] lowestPrice = new int[n];
        Arrays.fill(lowestPrice, Integer.MAX_VALUE);
        lowestPrice[src] = 0;
        int stepsCount = 0;
        while (!queue.isEmpty() && stepsCount <= k) {
            int movesForStep = queue.size(); // represents all possible routes from current node
            while (movesForStep > 0) {
                var current = queue.poll();
                Map<Integer, Integer> neighbors = graph.getOrDefault(current[0], Collections.emptyMap());
                for (var neighbor : neighbors.entrySet()) {
                    var number = neighbor.getKey();
                    var price = neighbor.getValue();
                    if (price + current[1] < lowestPrice[number]) {
                        lowestPrice[number] = price + current[1];
                        queue.add(new int[]{number, lowestPrice[number]});
                    }
                }
                movesForStep--;
            }
            stepsCount++;
        }


        return lowestPrice[dst] == Integer.MAX_VALUE ? -1 : lowestPrice[dst];
    }
}