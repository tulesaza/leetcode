package com.github.tulesaza.customsortstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    //  Sort with custom comparator
    // Time: O(n*log(n)), space: O(n), n - length of string
    public String customSortString1(String order, String s) {
        int[] customDictionary = new int[26];
        Arrays.fill(customDictionary, 26);
        for (int i = 0; i < order.length(); ++i) {
            customDictionary[order.charAt(i) - 'a'] = i;
        }
        List<Character> list = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); ++i) {
            list.add(s.charAt(i));
        }
        list.sort(Comparator.comparingInt(aChar -> customDictionary[aChar - 'a']));
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }

    // Calculate frequency
    // Time O(n), space O(n)
    public String customSortString2(String order, String s) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        // fill with existing chars in s by order
        for (int i = 0; i < order.length(); i++) {
            int index = order.charAt(i) - 'a';
            while (frequency[index]-- > 0) {
                sb.append(order.charAt(i));
            }
        }
        // fill with rest
        for (int i = 0; i < 26; i++) {
            while (frequency[i]-- > 0) {
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }
}