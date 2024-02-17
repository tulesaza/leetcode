package com.tulesaza.reverseinteger;

import java.util.LinkedList;

class Solution {
    public int reverse(int x) {
        int number = x;
        int reversed = 0;

        while (number != 0) {
            int digit = number % 10;
            // MIN < reversed * 10 + digit < MAX -> MIN/10 < reversed < MAX/10
            if (reversed < Integer.MIN_VALUE / 10 || reversed > Integer.MAX_VALUE / 10) {
                //System.out.println("Overflow");
                return 0;
            }
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        //System.out.println(reversed);
        return reversed;
    }

    public int reverseWithStack(int x) {
        boolean positive = x > 0;
        int number = Math.abs(x);
        int result = 0;
        LinkedList<Integer> digits = new LinkedList<>();
        while (number != 0) {
            digits.push(number % 10);
            number = number / 10;
        }

        int coef = 1;
        int power = 0;
        while (!digits.isEmpty()) {
            if (power >= 10) {
                result = 0;
                break;
            }
            int digit = digits.pop();
            if (power == 9 && digit >= 3) {
                result = 0;
                break;
            }

            int num = coef * digit;
            coef *= 10;
            power++;
            if (positive) {
                if (Integer.MAX_VALUE - result < num) {
                    result = 0;
                    break;
                }
                result += num;
            } else {
                if (result - (Integer.MIN_VALUE + 1) < num - 1) {
                    result = 0;
                    break;
                }
                result -= num;
            }
        }

        return result;
    }
}
