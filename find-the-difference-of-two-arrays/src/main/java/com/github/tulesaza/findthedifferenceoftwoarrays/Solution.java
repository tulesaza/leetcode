package com.github.tulesaza.findthedifferenceoftwoarrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    // no tests, it's too obvious
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var set1 = set(nums1);
        var set2 = set(nums2);
        return List.of(diff(set1, set2), diff(set2, set1));
    }

    private Set<Integer> set(int[] arr) {
        Set<Integer> result = new HashSet<>();
        for (int a : arr) {
            result.add(a);
        }
        return result;
    }

    private List<Integer> diff(Set<Integer> a, Set<Integer> b) {
        List<Integer> result = new ArrayList<>(a.size());
        for (int el : a) {
            if (!b.contains(el)) {
                result.add(el);
            }
        }
        return result;
    }
}