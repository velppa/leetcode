package _1277_count_square_submatrices_with_all_ones;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountSubmatrixTest {

    public int countSquares(int [][] matrix){
        int m = matrix.length; // number of rows
        int n = matrix[0].length; // number of columns
        int [][] dp = new int[m][n];
        int countSubmatrix = 0;

        for(int i = 0; i < m; i++){ // i - rows
            for(int j = 0; j < n; j++){ // j - columns
                if(matrix[i][j] == 1){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1; // Squares with size 1x1 in first row and first column
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    countSubmatrix += dp[i][j]; // add number of square count from dp[i][j]
                }
            }
        }
        return countSubmatrix;
    }

    @Test
    public void countSquaresTest(){
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        System.out.println(countSquares(matrix));
        assertEquals(15, countSquares(matrix));

        int[][] matrix2 = {
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0}
        };

        System.out.println(countSquares(matrix2));
        assertEquals(7, countSquares(matrix2));

    }
}
