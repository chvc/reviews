package od;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-25 22:47:51
 */
public class Od305 {
    //todo 做得不对

    static int[][] grid;
    static int[][] memo;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        grid = new int[n][m];
        memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int ans = f(grid, n - 1, m - 1);
        System.out.println(ans);
    }

    public static int f(int[][] grid, int i, int j) {

        // 如果越界了
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (i == 0) {
            int rowSum = 0;
            for (int k = 0; k <= j; k++) {
                rowSum += grid[i][k];
            }
            memo[i][j] = rowSum;
            return memo[i][j];
        }
        if (j == 0) {
            int colSum = 0;
            for (int k = 0; k <= i; k++) {
                colSum += grid[k][j];
            }
            memo[i][j] = colSum;
            return memo[i][j];
        }
        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }
        // 以i,j作为矩阵的右下角,0,0作为矩阵的左上角的矩阵最大和
        int ans = 0;
        int colSum = 0;
        for (int k = 0; k <= i; k++) {
            colSum += grid[k][j];
        }
        int rowSum = 0;
        for (int k = 0; k <= j; k++) {
            rowSum += grid[i][k];
        }
        int sum = rowSum + colSum - grid[i][j];
        // 比较 左边的 上边的 左上的 矩阵 哪个比较大
        if (colSum < 0) {
            ans = Math.max(f(grid, i, j - 1), ans);
        } else {
            ans = Math.max(f(grid, i, j - 1) + colSum, ans);
        }
        if (rowSum < 0) {
            ans = Math.max(f(grid, i - 1, j), ans);
        } else {
            ans = Math.max(f(grid, i - 1, j) + rowSum, ans);
        }
        if (sum < 0) {
            ans = Math.max(f(grid, i - 1, j - 1), ans);
        } else {
            ans = Math.max(f(grid, i - 1, j - 1) + sum, ans);
        }
        memo[i][j] = ans;
        return memo[i][j];
    }

}
