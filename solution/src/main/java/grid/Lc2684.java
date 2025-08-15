package grid;


import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-15 19:25:26
 */
public class Lc2684 {


    int m;
    int n;
    int res = 0;
    int[][] memo;

    public int maxMoves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        memo = new int[m][n];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int i = 0; i < m; i++) {
            int dfs = dfs(grid, i, 0, grid[i][0], 0);
            res = Math.max(dfs, res);
        }

        return res - 1;
    }

    public int dfs(int[][] grid, int i, int j, int target, int step) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return step;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int value = grid[i][j];
        if (j > 0 && value <= target) {
            return step;
        }

        int ans1 = dfs(grid, i - 1, j + 1, value, step + 1);
        int ans2 = dfs(grid, i, j + 1, value, step + 1);
        int ans3 = dfs(grid, i + 1, j + 1, value, step + 1);
        memo[i][j] = Math.max(Math.max(ans1, ans2), ans3);
        return memo[i][j];
    }

    public static void main(String[] args) {
        Lc2684 lc2684 = new Lc2684();
        System.out.println(lc2684.maxMoves(new int[][]{
                {3, 2, 4}, {2, 1, 9}, {1, 1, 7}
        }));
    }

}
