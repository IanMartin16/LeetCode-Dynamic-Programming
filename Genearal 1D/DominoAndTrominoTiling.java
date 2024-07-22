class DominoAndTrominoTiling {

    public static int numTilings(int n) {
        long[] dp = new long[4];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 5;
        int cur = n - 1;
        for (int i = 3; i < n; i++) {
            cur = i % 4;
            dp[cur] = (2 * dp[(cur + 3) % 4] + dp[(cur + 1) % 4]) % 1000000007;
        }
        return (int)dp[cur];
    }
}


//You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.


//Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.

//In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.