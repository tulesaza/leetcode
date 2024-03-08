package com.github.tulesaza.smallestnumberininfiniteset;


// because max number is 1000 this is better
class SmallestInfiniteSet {
    private int smallestIndex;
    private final boolean[] numbers;

    public SmallestInfiniteSet() {
        this.smallestIndex = 1;
        this.numbers = new boolean[1002];
    }

    // worst case O(n)
    public int popSmallest() {
        numbers[smallestIndex] = true;
        int result = smallestIndex;
        while (numbers[++smallestIndex]) {
        }
        //System.out.printf("popped: %d, new smallest: %d\n",result,smallestIndex);
        return result;
    }

    // O(1)
    public void addBack(int num) {
        if (numbers[num]) {
            numbers[num] = false;
            smallestIndex = Math.min(smallestIndex, num);
        }

    }
}