public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        // Initialize the DP array where dp[i] is the number of combinations to make up amount i
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case: There is one way to make up amount 0, which is using no numbers

        // Iterate through all amounts from 1 to target
        for (int i = 1; i <= target; i++) {
            // Iterate through all numbers in the nums array
            for (int num : nums) {
                // If the current number can contribute to the current amount
                if (i - num >= 0) {
                    dp[i] += dp[i - num]; // Add the number of ways to make up the remaining amount (i - num)
                }
            }
        }

        // The result is the number of ways to make up the target amount
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSum4 solution = new CombinationSum4();

        int[] nums1 = {1, 2, 3};
        int target1 = 4;
        System.out.println("Number of combinations for target " + target1 + ": " + solution.combinationSum4(nums1, target1)); // Output: 7

        int[] nums2 = {9};
        int target2 = 3;
        System.out.println("Number of combinations for target " + target2 + ": " + solution.combinationSum4(nums2, target2)); // Output: 0
    }
}


//Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

//The test cases are generated so that the answer can fit in a 32-bit integer.