package com.github.tulesaza.intersectionoftwoarrays;

import java.util.HashSet;
import java.util.Set;

class Solution {
    // 1. Sort both and iterate with two pointers, time O(n*log(n) + m*log(m)), space O(min(n,m))
    // 2. Hashset time O(n+m), space O(n+m)
    // 3. Table with size max number 1000 as set. O(n+m) O(1) space
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            if (set1.contains(n)) {
                set2.add(n);
            }
        }
        return set2.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        int[] possibleNumbers = new int[1001];
        for (int n : nums1) {
            possibleNumbers[n] = 1;
        }
        int count = 0;
        for (int n : nums2) {
            if (possibleNumbers[n] == 1) {
                possibleNumbers[n] = 2;
                count++;
            }
        }
        int[] result = new int[count];
        int j = 0;
        for (int i = 0; i < 1001; i++) {
            if (possibleNumbers[i] == 2) {
                result[j++] = i;
            }
        }
        return result;
    }
}