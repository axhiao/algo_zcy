package com.axhiao.aer.leetcode;

public class LongestPalindromeSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        int left = 0, right = 0;
        int maxLength = 1;
        int length = s.length();
        for (int i = 0; i < length - 1; i++) {
            // i
            int r = 1;
            while (i - r >= 0
                    && i + r < length
                    && s.charAt(i-r) == s.charAt(i+r)) {
                if (2*r+1 > maxLength) {
                    left = i - r;
                    right = i + r;
                    maxLength = right - left + 1;
                }
                r++;
            }
            // after i
            r = 1;
            while (i - (r-1) >= 0
                    && i + r < length
                    && s.charAt(i-(r-1)) == s.charAt(i+r)) {
                if (2*r > maxLength) {
                    left = i - (r-1);
                    right = i + r;
                    maxLength = right - left + 1;
                }
                r++;
            }
        }
        return s.substring(left, right+1);
    }

    public static void main(String[] args) {
        String s = "c";

        String r = longestPalindrome(s);

        System.out.println(r);

    }
}
