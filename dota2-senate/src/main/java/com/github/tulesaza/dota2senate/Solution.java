package com.github.tulesaza.dota2senate;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Deque<Integer> radiantQueue = new ArrayDeque<>(n);
        Deque<Integer> direQueue = new ArrayDeque<>(n);
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }

        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int radiantTurnIndex = radiantQueue.poll();
            int direTurnIndex = direQueue.poll();
            if (radiantTurnIndex < direTurnIndex) {
                radiantQueue.offer(radiantTurnIndex + n);
            } else {
                direQueue.offer(direTurnIndex + n);
            }
        }

        return radiantQueue.isEmpty() ? "Dire" : "Radiant";

    }
}
