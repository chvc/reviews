package grid;


import math.Lc878;
import tree.binary.Lc872;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-15 15:21:36
 */
public class Lc827 {
    int m;
    int n;

    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int id = 2;
        int[] size = new int[m * n];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果是岛的话
                if (grid[i][j] == 1) {
                    int ans = dfs(grid, i, j, id);
                    res = Math.max(res, ans);
                    size[id] = ans;
                    id++;
                }
            }
        }
        // 拿到了每一个岛的size 遍历网格中为0的地方
        boolean[] visited = new boolean[id];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int si = 0;
                    // 查看当前的水域的上下左右有哪些非水域的
                    int up, left, down, right;
                    up = i - 1 >= 0 ? grid[i - 1][j] : 0;
                    left = j - 1 >= 0 ? grid[i][j - 1] : 0;
                    down = i + 1 < m ? grid[i + 1][j] : 0;
                    right = j + 1 < n ? grid[i][j + 1] : 0;
                    si += 1 + size[up];
                    visited[up] = true;
                    if (!visited[down]) {
                        si += size[down];
                        visited[down] = true;
                    }
                    if (!visited[left]) {
                        si += size[left];
                        visited[left] = true;
                    }
                    if (!visited[right]) {
                        si += size[right];
                        visited[right] = true;
                    }
                    res = Math.max(si, res);
                    visited[up] = false;
                    visited[down] = false;
                    visited[left] = false;
                    visited[right] = false;
                }
            }
        }

        return res;
    }

    public int dfs(int[][] grid, int i, int j, int id) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        int ans = 0;

        grid[i][j] = id;
        ans += 1 + dfs(grid, i + 1, j, id) + dfs(grid, i - 1, j, id) + dfs(grid, i, j + 1, id) + dfs(grid, i, j - 1, id);
        return ans;
    }

    public static void main(String[] args) {
        Lc827 lc827 = new Lc827();
        System.out.println(lc827.largestIsland(new int[][]{
                {1, 0}, {0, 1}
        }));
    }
}
