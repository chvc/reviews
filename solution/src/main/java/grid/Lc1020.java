package grid;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-15 01:23:28
 */
public class Lc1020 {
    int m;
    int n;


    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // 先将边界的1染成0

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1) {
                    if (grid[i][j] == 1) {
                        dfs1(grid, i, j);
                    }
                }
                if (j == 0 || j == n - 1) {
                    if (grid[i][j] == 1) {
                        dfs1(grid, i, j);
                    }
                }
            }
        }

        // 再来访问为1的地方
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfs1(grid, i, j);
                }
            }
        }
        return count;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        // 往四个方向搜索
        // 修改当前位置
        grid[i][j] = 0;
        return 1 + dfs(grid, i + 1, j)
                + dfs(grid, i - 1, j)
                + dfs(grid, i, j + 1)
                + dfs(grid, i, j - 1);
    }

    public void dfs1(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
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

    public static void main(String[] args) {
        Lc1020 lc1020 = new Lc1020();
        lc1020.numEnclaves(new int[][]{
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        });
    }


}
