package od;


import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-03 23:54:02
 */
public class Od133APhotovoltaicSiteConstruction {

    static int n;
    static int m;
    static int h;
    static int w;
    static int[][] grid;
    static int[][] sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        w = h;
        int k = sc.nextInt();
        grid = new int[n][m];
        sum = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                sum[i + 1][j + 1] = grid[i][j];
            }
        }
        // 求区域和
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                sum[i][j] += sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
            }
        }
        // 求出每一个数字以
        int count = 0;
        for (int a = 1, c = a + h - 1; c <= n; a++, c++) {
            // 求出每一个数字以
            for (int b = 1, d = b + w - 1; d <= m; b++, d++) {
                if (regionSum(sum, a, b, c, d) >= k) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static int regionSum(int[][] sum, int a, int b, int c, int d) {
        return sum[c][d] - sum[c][b - 1] - sum[a - 1][d] + sum[a - 1][b - 1];
    }

}
