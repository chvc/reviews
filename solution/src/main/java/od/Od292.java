package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-23 22:14:58
 */
public class Od292 {

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
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && grid[i][j] == 1) {
                        queue.add(new int[]{i, j});
                        visited[i][j] = true;
                        while (!queue.isEmpty()) {
                            int size = queue.size();
                            for (int k = 0; k < size; k++) {
                                int[] element = queue.poll();
                                int x = element[0];
                                int y = element[1];
                                // newx newy
                                for (int l = 0; l < 4; l++) {
                                    int newx = x + move[l];
                                    int newy = y + move[l + 1];
                                    if (newx < n && newx >= 0 && newy < m && newy >= 0 && !visited[newx][newy] && grid[x][y] == 1) {
                                        queue.offer(new int[]{
                                                newx, newy
                                        });
                                        visited[newx][newy] = true;
                                    }
                                }
                            }
                            count += size;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

}
