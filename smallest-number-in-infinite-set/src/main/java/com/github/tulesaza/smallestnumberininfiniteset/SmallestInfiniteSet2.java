package com.github.tulesaza.smallestnumberininfiniteset;


import java.util.TreeSet;

class SmallestInfiniteSet2 {
    private final TreeSet<Integer> set;

    public SmallestInfiniteSet2() {
        this.set = new TreeSet<>();
        for (int i = 1; i <= 100; i++) {
            set.add(i);
        }
    }

    //  O(logN)
    public int popSmallest() {
        return set.pollFirst();
    }

    // O(LogN)
    public void addBack(int num) {
        set.add(num);
    }
}