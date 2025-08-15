package grid;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-14 23:32:58
 */
public class Lc3619 {

    int m;
    int n;

    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    int worth = dfs(grid, i, j);
                    if (worth % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }
        int worth = grid[i][j];
        grid[i][j] = 0;
        return worth + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
    }


}
