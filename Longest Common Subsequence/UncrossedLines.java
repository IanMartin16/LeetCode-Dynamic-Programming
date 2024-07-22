public class UncrossedLines {
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 2};
        int[] nums2 = {1, 2, 4};
        System.out.println(maxUncrossedLines(nums1, nums2)); // Output: 2

        nums1 = new int[]{2, 5, 1, 2, 5};
        nums2 = new int[]{10, 5, 2, 1, 5, 2};
        System.out.println(maxUncrossedLines(nums1, nums2)); // Output: 3

        nums1 = new int[]{1, 3, 7, 1, 7, 5};
        nums2 = new int[]{1, 9, 2, 5, 1};
        System.out.println(maxUncrossedLines(nums1, nums2)); // Output: 2
    }
}


//You are given two integer arrays nums1 and nums2. We write the integers of nums1 and nums2 (in the order they are given) on two separate horizontal lines.

//We may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:

//nums1[i] == nums2[j], and
//the line we draw does not intersect any other connecting (non-horizontal) line.
//Note that a connecting line cannot intersect even at the endpoints (i.e., each number can only belong to one connecting line).

//Return the maximum number of connecting lines we can draw in this way.