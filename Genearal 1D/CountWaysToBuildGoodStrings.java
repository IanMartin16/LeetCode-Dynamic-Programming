class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        final int MOD = 1000000007;

        // Create a DP array to store the number of good strings of each length
        int[] dp = new int[high + 1];
        dp[0] = 1; // There's one way to create an empty string

        // Iterate over each length from 1 to high
        for (int length = 1; length <= high; length++) {
            // If the current length can be obtained by appending '0' zero times
            if (length >= zero) {
                dp[length] = (dp[length] + dp[length - zero]) % MOD;
            }
            // If the current length can be obtained by appending '1' one times
            if (length >= one) {
                dp[length] = (dp[length] + dp[length - one]) % MOD;
            }
        }

        // Sum up the number of good strings of lengths from low to high
        int result = 0;
        for (int length = low; length <= high; length++) {
            result = (result + dp[length]) % MOD;
        }

        return result;
    }
}



//Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, 
//and then at each step perform either of the following:

//Append the character '0' zero times.
//Append the character '1' one times.
//This can be performed any number of times.

//A good string is a string constructed by the above process having a length between low and high (inclusive).

//Return the number of different good strings that can be constructed satisfying these properties. Since the answer can be large, 
//return it modulo 109 + 7.