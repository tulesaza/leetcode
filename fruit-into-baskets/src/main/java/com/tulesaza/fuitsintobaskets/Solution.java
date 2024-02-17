package com.tulesaza.fuitsintobaskets;

class Solution {

    public int totalFruit(int[] fruits) {
        int lastType = -1;
        int secondLastType = -1;
        int localMax = 0;
        int countContiniousLastType = 0;
        int max = 0;

        for (int fruit : fruits) {


            if (fruit == lastType || fruit == secondLastType) {
                localMax++;
            }
            // new type
            else {
                localMax = countContiniousLastType + 1;
            }

            // handle count of continuous type
            if (fruit == lastType) {
                countContiniousLastType++;
            } else {
                countContiniousLastType = 1;
                secondLastType = lastType;
                lastType = fruit;
            }


            max = Math.max(max, localMax);

        }
        return max;


    }
}