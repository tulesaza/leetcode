package com.tulesaza.longestcommonprefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = longestCommonPrefix(result, strs[i]);
            if (result.isEmpty()) {
                break;
            }
        }

        return result;
    }

    private String longestCommonPrefix(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                sb.append(a.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
