public class UniqueBST {
    public int numTrees(int n) {
        // dp[i] will store the number of unique BSTs that can be formed with i nodes
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1; // An empty tree
        dp[1] = 1; // A single node tree

        // Fill the dp array using the recursive formula
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        UniqueBST solution = new UniqueBST();
        int n = 3;
        System.out.println("Number of unique BSTs with " + n + " nodes: " + solution.numTrees(n));
    }
}


//Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.