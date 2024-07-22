public class DistinctSubsequences {
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[i][j] será el número de subsecuencias de s[0..i-1] que son iguales a t[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // Inicializar la primera columna, porque una subsecuencia vacía de t siempre es igual a cualquier subsecuencia de s
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Llenar la tabla dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s, t)); // Output: 3
    }
}


//Given two strings s and t, return the number of distinct subsequences of s which equals t.

//The test cases are generated so that the answer fits on a 32-bit signed integer.