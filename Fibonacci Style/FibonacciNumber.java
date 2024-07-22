public class FibonacciNumber {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("F(0) = " + fibonacci.fib(0)); // Output: 0
        System.out.println("F(1) = " + fibonacci.fib(1)); // Output: 1
        System.out.println("F(2) = " + fibonacci.fib(2)); // Output: 1
        System.out.println("F(3) = " + fibonacci.fib(3)); // Output: 2
        System.out.println("F(4) = " + fibonacci.fib(4)); // Output: 3
        System.out.println("F(5) = " + fibonacci.fib(5)); // Output: 5
        System.out.println("F(6) = " + fibonacci.fib(6)); // Output: 8
        System.out.println("F(10) = " + fibonacci.fib(10)); // Output: 55
    }
}


//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
//such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,