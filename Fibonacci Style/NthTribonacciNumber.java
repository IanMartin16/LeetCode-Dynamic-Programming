public class NthTribonacciNumber {

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int t0 = 0, t1 = 1, t2 = 1;
        int tn = 0;

        for (int i = 3; i <= n; i++) {
            tn = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }

        return tn;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("T(" + n + ") = " + tribonacci(n)); // Expected output: T(4) = 4
        
        n = 25;
        System.out.println("T(" + n + ") = " + tribonacci(n)); // Expected output: T(25) = 1389537
    }
}


//The Tribonacci sequence Tn is defined as follows: 

//T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

//Given n, return the value of Tn.