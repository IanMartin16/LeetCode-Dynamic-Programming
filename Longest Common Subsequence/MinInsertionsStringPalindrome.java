public class MinInsertionsStringPalindrome {
    public static int minInsertions(String s) {
        int n = s.length();
        String reversedS = new StringBuilder(s).reverse().toString();
        return n - longestCommonSubsequence(s, reversedS);
    }

    private static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(minInsertions(s)); // Output: 5

        s = "aabb";
        System.out.println(minInsertions(s)); // Output: 2

        s = "abc";
        System.out.println(minInsertions(s)); // Output: 2
    }
}


//Given a string s. In one step you can insert any character at any index of the string.

//Return the minimum number of steps to make s palindrome.

//A Palindrome String is one that reads the same backward as well as forward.