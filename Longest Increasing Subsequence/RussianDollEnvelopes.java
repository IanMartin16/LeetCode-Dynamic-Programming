import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }

        // Ordenar los sobres primero por ancho ascendente y luego por altura descendente
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });

        // Encontrar la subsecuencia creciente más larga en las alturas
        int n = envelopes.length;
        int[] dp = new int[n];
        int len = 0;

        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int index = Arrays.binarySearch(dp, 0, len, height);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = height;
            if (index == len) {
                len++;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(maxEnvelopes(envelopes)); // Output: 3
    }
}


//You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

//One envelope can fit into another if and only if both the width and height of one envelope are greater than the other 
//envelope's width and height.

//Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

//Note: You cannot rotate an envelope.