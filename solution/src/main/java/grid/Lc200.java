package grid;


import java.util.LinkedList;

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

    int[][] move = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public int numIslands2(char[][] grid) {
        // bfs
        m = grid.length;
        n = grid[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    queue.add(new int[]{
                            i, j
                    });
                    grid[i][j] = 0;
                    while (!queue.isEmpty()) {
                        int[] direction = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int newx = direction[0] + move[k][0];
                            int newy = direction[1] + move[k][1];
                            if (newx >= 0 && newx < n && newy >= 0 && newy < m && grid[newx][newy] == '1') {
                                grid[newx][newy] = 0;
                                queue.add(new int[]{
                                        newx, newy
                                });
                            }
                        }
                    }
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc200 lc200 = new Lc200();
        System.out.println(lc200.numIslands2(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));
    }

}
