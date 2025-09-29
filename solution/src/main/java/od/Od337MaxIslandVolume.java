package od;


import java.util.Scanner;

/**
 * P00054—最大岛屿体积
 *
 * @author chenghu
 * @since 2025-09-30 00:05:34
 */
public class Od337MaxIslandVolume {

    /**
     * 给你一个由 大于0的数（陆地）和 0（水）组成的的二维网格，请你计算网格中最大岛屿的体积。陆地的数表示所在岛屿的体积。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     * 输入描述
     * 第一行是二维网格的宽和高。
     * 后面几行是二维网格。
     * <p>
     * 输出描述
     * 输出岛屿的最大体积。
     * <p>
     * 样例
     * 输入
     * 5 5
     * 0 1 1 0 0
     * 0 1 1 0 0
     * 0 0 0 0 0
     * 0 0 1 2 3
     * 0 0 1 3 9
     * 输出
     * 19
     * ————————————————
     *
     * @param args
     */

    static int ans;
    static int n;
    static int m;
    static int[][] grid;

    public static void main(String[] args) {
        in();
        f();
        System.out.println(ans);
    }

    public static void in() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        ans = Integer.MIN_VALUE;
    }

    public static void f() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    int dfs = dfs(i, j, 0);
                    ans = Math.max(ans, dfs);
                }
            }
        }
    }

    public static int dfs(int i, int j, int k) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) {
            return k;
        }
        k += grid[i][j];
        grid[i][j] = 0;
        k = dfs(i - 1, j, k);
        k = dfs(i + 1, j, k);
        k = dfs(i, j - 1, k);
        k = dfs(i, j + 1, k);
        return k;
    }

}
