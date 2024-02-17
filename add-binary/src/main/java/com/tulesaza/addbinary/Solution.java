package com.tulesaza.addbinary;

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || sum == 1) {
            // Compute sum of last digits and carry
            sum += ((i >= 0) ? a.charAt(i) - '0' : 0);
            sum += ((j >= 0) ? b.charAt(j) - '0' : 0);
            // If current digit sum is 1 or 3, add 1 to result
            sb.append((char) (sum % 2 + '0'));
            // Compute carry
            sum /= 2;
            // Move to next digits
            i--;
            j--;
        }

        return sb.reverse().toString();
    }
}
