package com.github.tulesaza.numberofrecentcalls;

class RecentCounter2 {
    private final int[] calls = new int[10010];
    private int currentIndex;

    public RecentCounter2() {
    }

    // O(lgN)
    public int ping(int t) {
        calls[currentIndex] = t;
        currentIndex++;
        return currentIndex - search(t - 3000);
    }


    private int search(int x) {
        int left = 0, right = currentIndex;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (calls[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
