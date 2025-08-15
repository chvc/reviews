package grid;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-14 22:41:21
 */
public class Lc695 {

    int ans;
    int m;
    int n;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int dfs = dfs(grid, i, j);
                    ans = Math.max(dfs, ans);
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        int area = 1;
        grid[i][j] = 2;
        area += dfs(grid, i + 1, j);
        area += dfs(grid, i - 1, j);
        area += dfs(grid, i, j + 1);
        area += dfs(grid, i, j - 1);
        return area;
    }

}
