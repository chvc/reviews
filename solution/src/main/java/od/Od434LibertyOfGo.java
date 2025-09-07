package od;


import java.util.Arrays;
import java.util.Scanner;

/**
 * P00279—围棋的气
 *
 * @author chenghu
 * @since 2025-09-06 11:18:46
 */
public class Od434LibertyOfGo {

    static int MAXN = 19;
    static int[][] grid = new int[MAXN][MAXN];

    static boolean[][] bvisited = new boolean[MAXN][MAXN];
    static boolean[][] wvisited = new boolean[MAXN][MAXN];

    static int[] moved = new int[]{
            -1, 0, 1, 0, -1
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = -1;
                bvisited[i][j] = false;
                wvisited[i][j] = false;
            }
        }
        //
        int[] blackNums = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] whiteNums = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < blackNums.length; i += 2) {
            grid[blackNums[i]][blackNums[i + 1]] = 1;
        }
        for (int i = 0; i < whiteNums.length; i += 2) {
            grid[whiteNums[i]][whiteNums[i + 1]] = 0;
        }
        // 白棋用0表示 黑棋用1表示 空地用-1表示
        int b = 0;
        int w = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // 看下四个邻居是不是都是空地
                    for (int k = 0; k < 4; k++) {
                        int x = i + moved[k];
                        int y = j + moved[k + 1];
                        if (x >= 0 && x < n && y >= 0 && y < m && !bvisited[x][y] && grid[x][y] == -1) {
                            b++;
                            bvisited[x][y] = true;
                        }
                    }
                }
                if (grid[i][j] == 0) {
                    // 看下四个邻居是不是都是空地
                    for (int k = 0; k < 4; k++) {
                        int x = i + moved[k];
                        int y = j + moved[k + 1];
                        if (x >= 0 && x < n && y >= 0 && y < m && !wvisited[x][y] && grid[x][y] == -1) {
                            w++;
                            wvisited[x][y] = true;
                        }
                    }
                }
            }
        }
        System.out.println(b + " " + w);
    }

}
