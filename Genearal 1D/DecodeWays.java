class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // An empty string has one way to be decoded

        for (int i = 1; i <= n; i++) {
            // Single digit decode (1 to 9)
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Two digit decode (10 to 26)
            if (i > 1) {
                int twoDigit = Integer.parseInt(s.substring(i - 2, i));
                if (twoDigit >= 10 && twoDigit <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String encodedMessage1 = "12";
        System.out.println("Number of ways to decode \"" + encodedMessage1 + "\": " + solution.numDecodings(encodedMessage1)); // Output: 2

        String encodedMessage2 = "226";
        System.out.println("Number of ways to decode \"" + encodedMessage2 + "\": " + solution.numDecodings(encodedMessage2)); // Output: 3

        String encodedMessage3 = "0";
        System.out.println("Number of ways to decode \"" + encodedMessage3 + "\": " + solution.numDecodings(encodedMessage3)); // Output: 0

        String encodedMessage4 = "06";
        System.out.println("Number of ways to decode \"" + encodedMessage4 + "\": " + solution.numDecodings(encodedMessage4)); // Output: 0
    }
}


//You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:

//"1" -> 'A'

//"2" -> 'B'

//...

//"25" -> 'Y'

//"26" -> 'Z'

//However, while decoding the message, you realize that there are many different ways you can decode the message 
//because some codes are contained in other codes ("2" and "5" vs "25").

//For example, "11106" can be decoded into: