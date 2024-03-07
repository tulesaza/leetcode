package com.github.tulesaza.kthlargestelementinanarray;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num: nums){
            pq.offer(num);
        }
        int result = 0;
        while(k-- > 0 && !pq.isEmpty()) {
            result = pq.poll();
        }
        return result;
    }
}