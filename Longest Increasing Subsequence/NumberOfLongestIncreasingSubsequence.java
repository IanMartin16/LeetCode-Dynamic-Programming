public class NumberOfLongestIncreasingSubsequence {
    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] lengths = new int[n]; // lengths[i] será la longitud de la subsecuencia más larga que termina en nums[i]
        int[] counts = new int[n]; // counts[i] será el número de tales subsecuencias que terminan en nums[i]
        
        Arrays.fill(lengths, 1);
        Arrays.fill(counts, 1);
        
        int maxLength = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j]; // reset count because we found a longer subsequence
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j]; // add count because we found another subsequence of the same length
                    }
                }
            }
            maxLength = Math.max(maxLength, lengths[i]);
        }
        
        int numberOfLIS = 0;
        for (int i = 0; i < n; i++) {
            if (lengths[i] == maxLength) {
                numberOfLIS += counts[i];
            }
        }
        
        return numberOfLIS;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(findNumberOfLIS(nums)); // Output: 2
    }
}


//Given an integer array nums, return the number of longest increasing subsequences.

//Notice that the sequence has to be strictly increasing.