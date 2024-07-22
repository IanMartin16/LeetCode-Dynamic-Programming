public class CoinChange2 {
    
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;  // Base case: There is one way to make amount 0, which is to use no coins
        
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2 solution = new CoinChange2();
        
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println("Number of combinations to make up amount " + amount + ": " + solution.change(amount, coins));
        
        coins = new int[]{2};
        amount = 3;
        System.out.println("Number of combinations to make up amount " + amount + ": " + solution.change(amount, coins));
        
        coins = new int[]{10};
        amount = 10;
        System.out.println("Number of combinations to make up amount " + amount + ": " + solution.change(amount, coins));
    }
}


//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

//Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

//You may assume that you have an infinite number of each kind of coin.

//The answer is guaranteed to fit into a signed 32-bit integer.