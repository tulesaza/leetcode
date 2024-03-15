package com.github.tulesaza.productofarrayexceptself;

class Solution {

    /*
     * Given: [x0, x1, x2, x3], expected: [x1*x2*x3, x0*x2*x3, x0*x1*x3, x0*x1*x2], division is not allowed
     * Desired time complexity O(n), now other DS except result are not allowed.
     * So calculate product and divide is not an option
     * Idea - prefix product from left to right and right to left:
     * -> [ 1,              x0,         x0*x1,     x0*x1*x2,  x0*x1*x2*x3], from left to right
     * <- [x3*x2*x1*x0,   x3*x2*x1,     x3*x2,           x3,          1], from right to left
     * If we shift them and do product of same indexes:
     *      shift        [ 1,              x0,         x0*x1,     x0*x1*x2,  x0*x1*x2*x3]
     *    [x3*x2*x1*x0,   x3*x2*x1,     x3*x2,           x3,          1]
     *  product: [ 1*x3*x2*x1, x0*x3*x2, x0*x1*x3, x0*x1*x2*1] which is result
     *
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        // from left to right
        for (int i = 0, leftProduct = 1; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }
        // from right to left
        for (int i = n - 1, rightProduct = 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }
}