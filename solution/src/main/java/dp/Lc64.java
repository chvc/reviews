package dp;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-10 23:04:56
 */
public class Lc64 {



/*
    Integer[][] memo;
    int m;
    int n;

    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        memo = new Integer[m][n];
        memo[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                f(i, j, grid);
            }
        }
        return memo[0][0];
    }

    public int f(int i, int j, int[][] grid) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }
        if (i == m - 1) {
            memo[i][j] = f(i, j + 1, grid) + grid[i][j];
            return grid[i][j];
        }
        if (j == n - 1) {
            memo[i][j] = f(i + 1, j, grid) + grid[i][j];
            return grid[i][j];
        }
        memo[i][j] = Math.min(f(i + 1, j, grid), f(i, j + 1, grid)) + grid[i][j];
        return memo[i][j];
    }*/

//    Integer[][] memo;
//    int m;
//    int n;
//
//    public int minPathSum(int[][] grid) {
//        m = grid.length;
//        n = grid[0].length;
//        memo = new Integer[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                f(i, j, grid);
//            }
//        }
//        return memo[m - 1][n - 1];
//    }
//
//    public int f(int i, int j, int[][] grid) {
//        if (memo[i][j] != null) {
//            return memo[i][j];
//        }
//        if (i == 0 && j == 0) {
//            memo[i][j] = grid[0][0];
//            return memo[i][j];
//        }
//        if (i == 0) {
//            memo[i][j] = f(0, j - 1, grid) + grid[i][j];
//            return grid[i][j];
//        }
//        if (j == 0) {
//            memo[i][j] = f(i - 1, 0, grid) + grid[i][j];
//            return grid[i][j];
//        }
//        memo[i][j] = Math.min(f(i - 1, j, grid), f(i, j - 1, grid)) + grid[i][j];
//        return memo[i][j];
//    }

    public static void main(String[] args) {
        Lc64 lc64 = new Lc64();
        System.out.println(lc64.minPathSum(new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        }));
    }


    Integer[][] memo;
    int m;
    int n;

    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        memo = new Integer[m][n];
        memo[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                f(i, j, grid);
            }
        }
        return memo[0][0];
    }

    public int f(int i, int j, int[][] grid) {
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }
        if (i == m - 1) {
            memo[i][j] = f(i, j + 1, grid) + grid[i][j];
            return grid[i][j];
        }
        if (j == n - 1) {
            memo[i][j] = f(i + 1, j, grid) + grid[i][j];
            return grid[i][j];
        }
        memo[i][j] = Math.min(f(i + 1, j, grid), f(i, j + 1, grid)) + grid[i][j];
        return memo[i][j];
    }

}
