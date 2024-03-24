package com.github.tulesaza.findtheduplicatenumber;

class Solution {
    // Time O(n), Space O(1)
    // [1,3,4,2,2], length 5, range 1 - 4 -> linked list: 1 -> 3 -> 2 -> 4
    //                                                              1____|
    // fast and slow Floyd algorithm
    public int findDuplicate1(int[] nums) {
        int fast = nums[0], slow = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


    // Time O(n*log(n)), Space O(1)
    // values are in range 1 and nums.length - 1
    // [1,3,4,2,2]
    // range 1 - 4, left 1 , right 4
    // mid 2, count 3 -> left 1, right 2
    // mid 1 count 1 -> left 2, right 2
    public int findDuplicate2(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}