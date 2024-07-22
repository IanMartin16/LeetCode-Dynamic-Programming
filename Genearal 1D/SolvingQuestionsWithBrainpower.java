class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; // Initialize dp array

        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];

            // Option 1: Skip the current question
            long skip = dp[i + 1];

            // Option 2: Solve the current question
            long solve = points;
            if (i + brainpower + 1 < n) {
                solve += dp[i + brainpower + 1];
            }

            // Take the maximum of skipping or solving the current question
            dp[i] = Math.max(skip, solve);
        }

        // The answer is the maximum points we can earn starting from question 0
        return dp[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] questions1 = {{3, 2}, {4, 3}, {4, 4}, {2, 5}};
        System.out.println("Maximum points: " + solution.mostPoints(questions1)); // Output: 5
        
        int[][] questions2 = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        System.out.println("Maximum points: " + solution.mostPoints(questions2)); // Output: 7
    }
}


//You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].

//The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.

//For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
//If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
//If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
//Return the maximum points you can earn for the exam.