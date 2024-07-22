import java.util.HashSet;
import java.util.Set;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // Create a set of travel days for O(1) look-up.
        Set<Integer> travelDays = new HashSet<>();
        for (int day : days) {
            travelDays.add(day);
        }

        // The last day of travel in the input.
        int lastDay = days[days.length - 1];

        // DP array to store the minimum cost up to each day.
        int[] dp = new int[lastDay + 1];

        for (int i = 1; i <= lastDay; i++) {
            if (!travelDays.contains(i)) {
                dp[i] = dp[i - 1]; // If not traveling this day, cost remains same as previous day.
            } else {
                int cost1 = dp[i - 1] + costs[0]; // Cost with 1-day pass.
                int cost7 = dp[Math.max(0, i - 7)] + costs[1]; // Cost with 7-day pass.
                int cost30 = dp[Math.max(0, i - 30)] + costs[2]; // Cost with 30-day pass.
                dp[i] = Math.min(cost1, Math.min(cost7, cost30)); // Choose the minimum cost.
            }
        }

        return dp[lastDay];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] days1 = {1, 4, 6, 7, 8, 20};
        int[] costs1 = {2, 7, 15};
        System.out.println("Minimum cost for days1: " + solution.mincostTickets(days1, costs1)); // Output: 11

        int[] days2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs2 = {2, 7, 15};
        System.out.println("Minimum cost for days2: " + solution.mincostTickets(days2, costs2)); // Output: 17
    }
}


//You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. 
//Each day is an integer from 1 to 365.

//Train tickets are sold in three different ways:

//a 1-day pass is sold for costs[0] dollars,
//a 7-day pass is sold for costs[1] dollars, and
//a 30-day pass is sold for costs[2] dollars.
//The passes allow that many days of consecutive travel.

//For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
//Return the minimum number of dollars you need to travel every day in the given list of days.