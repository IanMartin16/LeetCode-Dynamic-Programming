public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Initialize the first row and first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // Fill the dp array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m1 = 3, n1 = 7;
        int m2 = 3, n2 = 2;

        System.out.println(uniquePaths(m1, n1)); // Expected output: 28
        System.out.println(uniquePaths(m2, n2)); // Expected output: 3
    }
}


//There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

//Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

//The test cases are generated so that the answer will be less than or equal to 2 * 109.