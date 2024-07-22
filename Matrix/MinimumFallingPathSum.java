public class MinimumFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // Crear una copia de la matriz original para no modificarla directamente
        int[][] dp = new int[n][n];
        
        // Inicializar la última fila de dp con los valores de la última fila de matrix
        for (int col = 0; col < n; col++) {
            dp[n-1][col] = matrix[n-1][col];
        }

        // Llenar la matriz dp desde la penúltima fila hasta la primera
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int down = dp[row + 1][col];
                int downLeft = col > 0 ? dp[row + 1][col - 1] : Integer.MAX_VALUE;
                int downRight = col < n - 1 ? dp[row + 1][col + 1] : Integer.MAX_VALUE;
                dp[row][col] = matrix[row][col] + Math.min(down, Math.min(downLeft, downRight));
            }
        }

        // Encontrar el valor mínimo en la primera fila de dp
        int minPathSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minPathSum = Math.min(minPathSum, dp[0][col]);
        }

        return minPathSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };

        System.out.println(minFallingPathSum(matrix)); // Output: 13
    }
}


//Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

//A falling path starts at any element in the first row and chooses the element in the next row that is either directly 
//below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), 
//(row + 1, col), or (row + 1, col + 1).