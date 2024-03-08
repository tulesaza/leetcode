package com.github.tulesaza.numberofrecentcalls;

import java.util.Deque;
import java.util.LinkedList;


// max N count if calls is 10^4, not that big
class RecentCounter {

    private final Deque<Integer> queue = new LinkedList<>();

    public RecentCounter() {

    }

    // O(1), max 3000
    public int ping(int t) {
        queue.offer(t);
        while(!queue.isEmpty() && queue.peek() < t - 3000){
            queue.poll();
        }
        return queue.size();

    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */