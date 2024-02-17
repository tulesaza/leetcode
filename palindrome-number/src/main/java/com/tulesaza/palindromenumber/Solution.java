package com.tulesaza.palindromenumber;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reversed = 0;
        int reminder = x;
        while (reminder != 0) {
            int digit = reminder % 10;
            reversed = reversed * 10 + digit;
            reminder /= 10;
        }
        return reversed == x;
    }
}
