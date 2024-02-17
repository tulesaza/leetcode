package com.tulesaza.twosum;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, LinkedList<Integer>> number2locations = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            var locations = number2locations.getOrDefault(nums[i], new LinkedList<>());
            locations.add(i);
            number2locations.put(nums[i], locations);
        }
        int[] result = new int[2];
        for (var entry : number2locations.entrySet()) {
            int number = entry.getKey();
            LinkedList<Integer> locations = entry.getValue();
            if (number + number == target && locations.size() >= 2) {
                for (int i = 0; i < result.length; i++) {
                    result[i] = locations.pop();
                }
                break;
            } else if (number2locations.containsKey(target - number)) {
                result[0] = locations.pop();
                result[1] = number2locations.get(target - number).pop();
                break;
            }
        }

        return result;
    }
}