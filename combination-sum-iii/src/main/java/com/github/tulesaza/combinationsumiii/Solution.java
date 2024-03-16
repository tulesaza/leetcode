package com.github.tulesaza.combinationsumiii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> combination = new ArrayDeque<>();
        dfs(1, result, combination, k, n);
        return result;
    }

    private void dfs(int start, List<List<Integer>> result, Deque<Integer> combination, int count, int target) {
        if (count == 0) {
            if (target == 0) {
                result.add(new ArrayList<>(combination));
            }
            return;
        }
        for (int i = start; i <= 9; ++i) {
            combination.addLast(i);
            dfs(i + 1, result, combination, count - 1, target - i);
            combination.removeLast();
        }
    }
}
