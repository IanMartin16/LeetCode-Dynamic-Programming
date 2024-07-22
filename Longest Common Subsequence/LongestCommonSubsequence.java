public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        // Fill the dp array
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        
        System.out.println(longestCommonSubsequence(text1, text2)); // Expected output: 3
        
        text1 = "abc";
        text2 = "abc";
        
        System.out.println(longestCommonSubsequence(text1, text2)); // Expected output: 3
        
        text1 = "abc";
        text2 = "def";
        
        System.out.println(longestCommonSubsequence(text1, text2)); // Expected output: 0
    }
}


//Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

//A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

//For example, "ace" is a subsequence of "abcde".
//A common subsequence of two strings is a subsequence that is common to both strings.