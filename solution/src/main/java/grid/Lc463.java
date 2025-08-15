package grid;


import backtrack.Lc46;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-15 00:33:39
 */
public class Lc463 {

    int ans = 0;
    int m;
    int n;


    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }

        int len = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    // 下面
                    if (i - 1 >= 0) {
                        ans += grid[i - 1][j] == 2 ? 1 : 0;
                    }
                    // 上面
                    if (i + 1 < m) {
                        ans += grid[i + 1][j] == 2 ? 1 : 0;
                    }
                    // 左边
                    if (j - 1 >= 0) {
                        ans += grid[i][j - 1] == 2 ? 1 : 0;
                    }
                    // 右边
                    if (j + 1 < n) {
                        ans += grid[i][j + 1] == 2 ? 1 : 0;
                    }
                }
                if (grid[i][j] == 2) {
                    if (i == 0) {
                        ans++;
                    }
                    if (i == m - 1) {
                        ans++;
                    }
                    if (j == 0) {
                        ans++;
                    }
                    if (j == n - 1) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return;
        }
        // 往四个方向搜索
        // 修改当前位置
        grid[i][j] = 2;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        Lc463 lc463 = new Lc463();
        System.out.println(lc463.islandPerimeter(new int[][]{
                {0,1}
        }));
    }

}
