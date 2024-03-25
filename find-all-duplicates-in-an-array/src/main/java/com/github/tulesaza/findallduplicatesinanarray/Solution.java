package com.github.tulesaza.findallduplicatesinanarray;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // Time O(n), space O(1) except resulting arraylist, modifying input.
    // size of input is n and range is from [1;n] ->  indexes are in range [0;n-1],for k from [1;n] , k-1 is an index
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(num));
            } else {
                nums[index] *= -1;
            }
        }
        return result;
    }
}