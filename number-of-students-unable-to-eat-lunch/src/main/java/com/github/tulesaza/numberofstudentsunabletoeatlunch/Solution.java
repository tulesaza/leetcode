package com.github.tulesaza.numberofstudentsunabletoeatlunch;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int studentOnes = 0;
        for (int student : students) {
            if (student == 1) {
                ++studentOnes;
            }
        }
        int studentZeros = n - studentOnes;
        int i = 0;
        while (i < n) {
            if (sandwiches[i] == 1) {
                if (studentOnes > 0) {
                    studentOnes--;
                } else {
                    break;
                }
            } else {
                if (studentZeros > 0) {
                    studentZeros--;
                } else {
                    break;
                }
            }
            i++;
        }
        return n - i;
    }
}