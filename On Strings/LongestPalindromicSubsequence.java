public class LongestPalindromicSubsequence {
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp[i][j] será la longitud de la subsecuencia palindrómica más larga en s[i..j]
        int[][] dp = new int[n][n];

        // Todas las subsecuencias de longitud 1 son palíndromas
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Llenar la tabla dp
        for (int length = 2; length <= n; length++) { // length es la longitud de la subsecuencia
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1; // Final de la subsecuencia
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // La longitud de la subsecuencia palindrómica más larga estará en dp[0][n-1]
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s)); // Output: 4
    }
}


//Given a string s, find the longest palindromic subsequence's length in s.

//A subsequence is a sequence that can be derived from another sequence 
//by deleting some or no elements without changing the order of the remaining elements.