package od.exam.c;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * P00320—需要打开多少监视器/统计监控器
 *
 * @author chenghu
 * @since 2025-08-23 22:14:58
 */
public class Od292CountingMonitor {

    static int n;

    static int m;

    static int[][] grid;

    static boolean[][] visited;

    // x-1 y 上
    // x y+1 右
    // x+1 y 下
    // x y-1 左
    static int[] move = new int[]{-1, 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(reader);
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            grid = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    in.nextToken();
                    int v = (int) in.nval;
                    grid[i][j] = v;
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 调整实现
                    if (grid[i][j] == 1) {
                        for (int l = 0; l < 4; l++) {
                            int newx = i + move[l];
                            int newy = j + move[l + 1];
                            if (newx < n && newx >= 0 && newy < m && newy >= 0) {
                                if (grid[newx][newy] == 0) {
                                    grid[newx][newy] = 2;
                                }
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 调整实现
                    if (grid[i][j] != 0) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

}
