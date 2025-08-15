package grid;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-14 20:21:11
 */
public class Lc200 {

    int ans = 0;
    int m;
    int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        }
        // 往四个方向搜索
        // 修改当前位置
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}
