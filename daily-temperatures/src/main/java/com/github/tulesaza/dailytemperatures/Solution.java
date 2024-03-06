package com.github.tulesaza.dailytemperatures;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] daysTillWarmer = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int indexOfColderDay = stack.pop();
                daysTillWarmer[indexOfColderDay] = i - indexOfColderDay;
            }
            stack.push(i);
        }
        return daysTillWarmer;
    }
}
