public class ManachersAlgorithm {

    // Time O(n)
    // Space O(n)
    public String longestPalindrome(String s) {
        StringBuilder sClean = new StringBuilder("|");
        for (char c : s.toCharArray()) {
            sClean.append(c).append("|");
        }
        int[] maxRadiusForCenter = new int[sClean.length()];
        int rightCenter = 0, rightRadius = 0;
        int longestPalindromeCenter = 0, longestPalindromeRadius = 0;
        int radius;
        for (int center = 0; center < sClean.length(); center++) {
            if (center < rightCenter + rightRadius) {
                radius = maxRadiusForCenter[rightCenter - (center - rightCenter)];
                if (radius < rightCenter + rightRadius - center) { // case A, short inside long
                    maxRadiusForCenter[center] = radius;
                    continue;
                } else if (radius > rightCenter + rightRadius - center) { //case B, short crosses left border of long
                    maxRadiusForCenter[center] = rightCenter + rightRadius - center;
                    continue;
                } else { //case C, short shares left border with long
                    // pass
                }
            } else {
                radius = 0;
            }
            while (center - radius > 0 && center + radius < sClean.length() - 1 &&
                    sClean.charAt(center - radius - 1) == sClean.charAt(center + radius + 1)) {
                radius++;
            }
            maxRadiusForCenter[center] = radius;
            if (radius > longestPalindromeRadius) {
                longestPalindromeCenter = center;
                longestPalindromeRadius = radius;
            }
            if (center + radius > rightCenter + rightRadius) {
                rightCenter = center;
                rightRadius = radius;
            }
        }

        return sClean
                .substring(longestPalindromeCenter - longestPalindromeRadius,
                           longestPalindromeCenter + longestPalindromeRadius + 1)
                .replace("|", "");

    }
}
