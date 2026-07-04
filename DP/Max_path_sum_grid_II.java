// You are given a matrix mat[][] of size n x m where each element is a positive integer. Starting from any cell in the first row, you are allowed to move to the next row, but with specific movement constraints. From any cell (r, c) in the current row, you can move to any of the three possible positions :

// (r+1, c-1) — move diagonally to the left.
// (r+1, c) — move directly down.
// (r+1, c+1) — move diagonally to the right.
// Find the maximum sum of any path starting from any column in the first row and ending at any column in the last row, following the above movement constraints.

// Examples :

// Input: mat[][] = [[3, 6, 1], [2, 3, 4], [5, 5, 1]]
// Output: 15
// Explaination: The best path is (0, 1) -> (1, 2) -> (2, 1). It gives the maximum sum as 15.

import java.util.Arrays;

public class Max_path_sum_grid_II {
    
}
class Solution {
    int[][] dp;
    int[][] mat;
    int n, m;
    int solve(int i, int j) {
        if (j < 0 || j >= m)
            return Integer.MIN_VALUE;
        if (i == n - 1)
            return mat[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int left = mat[i][j] +solve(i + 1, j - 1);
        int down = mat[i][j] +solve(i + 1, j);
        int right = mat[i][j] +solve(i + 1, j + 1);
        return dp[i][j] =  Math.max(left, Math.max(down, right));
    }

    public int maximumPath(int[][] matrix) {
        mat = matrix;
        n = mat.length;
        m = mat[0].length;
        dp = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        int ans = 0;
        // Start from every column in the first row
        for (int j = 0; j < m; j++) {
            ans = Math.max(ans, solve(0, j));
        }
        return ans;
    }
}


