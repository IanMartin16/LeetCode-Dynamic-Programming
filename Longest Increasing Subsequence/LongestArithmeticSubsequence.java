import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {
    public static int longestArithSeqLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int length = dp[j].getOrDefault(diff, 1) + 1;
                dp[i].put(diff, length);
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 12};
        System.out.println(longestArithSeqLength(nums)); // Output: 4

        nums = new int[]{9, 4, 7, 2, 10};
        System.out.println(longestArithSeqLength(nums)); // Output: 3
    }
}


//vGiven an array nums of integers, return the length of the longest arithmetic subsequence in nums.

//Note that:

//A subsequence is an array that can be derived from another array by deleting some or no elements without changing 
//the order of the remaining elements.
//A sequence seq is arithmetic if seq[i + 1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).