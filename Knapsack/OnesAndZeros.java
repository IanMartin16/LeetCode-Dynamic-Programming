class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // Initialize the DP array
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        // Loop through all strings
        for (int i = 1; i <= strs.length; i++) {
            int[] count = countZeroesOnes(strs[i - 1]);
            int zeros = count[0];
            int ones = count[1];

            // Loop through all possible numbers of 0's and 1's
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    private int[] countZeroesOnes(String str) {
        int[] count = new int[2];
        for (char c : str.toCharArray()) {
            if (c == '0') {
                count[0]++;
            } else {
                count[1]++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs1 = {"10", "0001", "111001", "1", "0"};
        int m1 = 5, n1 = 3;
        System.out.println("Maximum size of subset: " + solution.findMaxForm(strs1, m1, n1)); // Output: 4

        String[] strs2 = {"10", "0", "1"};
        int m2 = 1, n2 = 1;
        System.out.println("Maximum size of subset: " + solution.findMaxForm(strs2, m2, n2)); // Output: 2
    }
}


//You are given an array of binary strings strs and two integers m and n.

//Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

//A set x is a subset of a set y if all elements of x are also elements of y.