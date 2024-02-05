class Solution {

    // Time O(n^2)
    // Space O(1)
    // TODO try to implement Manacher's O(n) algorithm
    public String longestPalindrome(String s) {
        int palindromeStart = 0;
        int palindromeEnd = 0;

        for (int oddCenter = 0; oddCenter < s.length(); oddCenter++) {
            int oddLength = maxLengthFromCenter(oddCenter, oddCenter, s);
            if (oddLength > palindromeEnd - palindromeStart + 1) {
                var radius = oddLength / 2;
                palindromeStart = oddCenter - radius;
                palindromeEnd = oddCenter + radius;
            }
        }
        for (int evenCenter = 0; evenCenter < s.length() - 1; evenCenter++) {
            int evenLength = maxLengthFromCenter(evenCenter, evenCenter + 1, s);
            if (evenLength > palindromeEnd - palindromeStart + 1) {
                var radius = evenLength / 2 - 1;
                palindromeStart = evenCenter - radius;
                palindromeEnd = evenCenter + 1 + radius;
            }
        }

        return s.substring(palindromeStart, palindromeEnd + 1);
    }


    private int maxLengthFromCenter(int initialLeftInx, int initialRightInx, String s) {
        int left = initialLeftInx;
        int right = initialRightInx;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1; // (r-1) - (l+1) + 1

    }
}