public class PerfectSquares {
    
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        
        // Initialize dp array with maximum values
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        dp[0] = 0;  // Base case
        
        // Compute the least number of perfect squares for each number up to n
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares solution = new PerfectSquares();
        
        int n = 12;
        System.out.println("Least number of perfect squares summing to " + n + ": " + solution.numSquares(n));
        
        n = 13;
        System.out.println("Least number of perfect squares summing to " + n + ": " + solution.numSquares(n));
    }
}


//Given an integer n, return the least number of perfect square numbers that sum to n.

//A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. 
//For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.