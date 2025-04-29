class Solution {
    public int longestPalindrome(String s, String t) {
        int max = 0;
        // naive way to reverse t
        StringBuilder sb = new StringBuilder();
        sb.append(t).reverse();
        String s1 = sb.toString();
        // these store the length of longest palindrome starting at each index
        int[] maxPalin1 = new int[s.length()];
        int[] maxPalin2 = new int[s1.length()];

        
        // constructing maxPalin1
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    maxPalin1[i] = j - i + 1;
                    if (maxPalin1[i] > max) {
                        // to cover cases where longestPalindrome is in s itself
                        max = maxPalin1[i];
                    }
                }
            }
        }

        // constructing maxPalin2
        for (int i = 0; i < s1.length(); i++) {
            for (int j = i; j < s1.length(); j++) {
                if (isPalindrome(s1.substring(i, j + 1))) {
                    maxPalin2[i] = j - i + 1;
                    if (maxPalin2[i] > max) {
                        // to cover cases where longest palindrome is in t itself
                        max = maxPalin2[i];
                    }
                }
            }
        }

        // 2-d dp to track longest matching substring till index i in s, and j in s1
        int[][] dp = new int[s.length() + 1][s1.length() + 1];
        dp[0][0] = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (s.charAt(i) == s1.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    int r1 = 0;
                    if (i < s.length() - 1) {
                        r1 = maxPalin1[i + 1];
                    }
                    int r2 = 0;
                    if (j < s1.length() - 1) {
                        r2 = maxPalin2[j + 1];
                    }
                    int cur = 2 * dp[i + 1][j + 1] + Math.max(r1, r2);
                    if (cur > max) {
                        max = cur;
                    }
                }
            }
        }

        return max;
    }

    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}