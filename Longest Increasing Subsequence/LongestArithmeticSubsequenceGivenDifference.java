import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceGivenDifference {
    public static int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLength = 0;

        for (int num : arr) {
            int prev = num - difference;
            int length = dp.getOrDefault(prev, 0) + 1;
            dp.put(num, length);
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 8, 5, 3, 4, 2, 1};
        int difference = 2;
        System.out.println(longestSubsequence(arr, difference)); // Output: 4
    }
}


//Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an 
//arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

//A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.