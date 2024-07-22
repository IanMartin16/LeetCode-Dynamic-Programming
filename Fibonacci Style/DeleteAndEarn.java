import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Step 1: Count the frequency of each number
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxNum = 0;
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            maxNum = Math.max(maxNum, num);
        }

        // Step 2: Create an array to store points for each number
        int[] points = new int[maxNum + 1];
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            points[num] = num * count;
        }

        // Step 3: Apply the dynamic programming approach to find the maximum points
        int[] dp = new int[maxNum + 1];
        dp[0] = points[0];
        dp[1] = Math.max(points[0], points[1]);
        
        for (int i = 2; i <= maxNum; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + points[i]);
        }

        return dp[maxNum];
    }

    public static void main(String[] args) {
        DeleteAndEarn solution = new DeleteAndEarn();
        int[] nums = {3, 4, 2};
        System.out.println(solution.deleteAndEarn(nums)); // Output: 6

        int[] nums2 = {2, 2, 3, 3, 3, 4};
        System.out.println(solution.deleteAndEarn(nums2)); // Output: 9
    }
}


//You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

//Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
//Return the maximum number of points you can earn by applying the above operation some number of times.