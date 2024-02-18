package com.github.tulesaza.validperfect.square;

import java.time.Duration;
import java.time.Instant;

class Solution {

    private final Approach approach;

    public Solution(Approach approach) {
        this.approach = approach;
    }

    public Solution() {
        this.approach = Approach.BINARY_SEARCH;
    }

    public boolean isPerfectSquare(int num) {
        Instant start = Instant.now();
        boolean result = switch (approach) {
            case LINEAR -> naiveLinear(num);
            case BINARY_SEARCH -> binarySearch(num);
        };
        Instant end = Instant.now();
        System.out.printf("%s, n=%d, elapsed time=%d ms\n", approach, num, Duration.between(start, end).toMillis());
        return result;
    }

    private boolean binarySearch(int num) {
        if (num < 2) {
            return true;
        }
        int left = 1;
        int right = Math.min(num / 2, (1 << 14) * 3); // 1.5 (>sqrt(2)) * 2^15 -> 2^14 * 3

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid; // handle overflow
            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }

        }

        return false;
    }

    private boolean naiveLinear(int num) {
        if (num < 2) {
            return true;
        }
        for (int i = 0; i < Math.min(num / 2 + 1, 1 << 16); i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }


    enum Approach {
        BINARY_SEARCH, LINEAR
    }
}