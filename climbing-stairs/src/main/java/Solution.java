class Solution {

    private final Approach approach;

    public Solution(Approach approach) {
        this.approach = approach;
    }

    public int climbStairs(int n) {
        return switch (approach) {
            case TOP_DOWN -> topDown(n);
            case BOTTOM_UP -> bottomUp(n);
        };
    }

    private int bottomUp(int n) {
        int[] combinationsForHeight = new int[n + 1];
        combinationsForHeight[0] = 1;
        combinationsForHeight[1] = 1;
        for (int i = 2; i <= n; i++) {
            combinationsForHeight[i] = combinationsForHeight[i - 1] + combinationsForHeight[i - 2];
        }
        return combinationsForHeight[n];
    }

    private int topDown(int n) {
        return doDown(n, 1, 1);
    }

    private int doDown(int n, int Nminus2, int Nminus1) {
        if (n == 0)
            return Nminus2;
        if (n == 1)
            return Nminus1;
        return doDown(n - 1, Nminus1, Nminus2 + Nminus1);
    }


    enum Approach {
        BOTTOM_UP, TOP_DOWN
    }
}