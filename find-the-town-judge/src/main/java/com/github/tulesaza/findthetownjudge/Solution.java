package com.github.tulesaza.findthetownjudge;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] votes = new int[n];
        Set<Integer> trustsNobody = IntStream.range(1, n + 1).collect(HashSet::new, Set::add, Set::addAll);
        for (int[] relation : trust) {
            votes[relation[1] - 1]++;
            trustsNobody.remove(relation[0]);
        }
        int max = -1;
        int maxLabel = -1;
        for (int i = 0; i < votes.length; i++) {
            if (max < votes[i]) {
                maxLabel = i + 1;
                max = votes[i];
            }
        }
        return max == n - 1 && trustsNobody.contains(maxLabel) ? maxLabel : -1;
    }
}
