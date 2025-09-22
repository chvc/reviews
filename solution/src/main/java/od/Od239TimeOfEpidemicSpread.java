package od;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * #P00389—计算疫情扩散时间
 *
 * @author chenghu
 * @since 2025-09-14 13:36:56
 */
public class Od239TimeOfEpidemicSpread {

    static int n;
    static int m;
    static int[][] grid;

    static int[] move = new int[]{
            -1, 0, 1, 0, -1
    };


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int len = nums.length;
        int sqrt = (int) Math.sqrt(len);
        n = sqrt;
        m = sqrt;
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = nums[n * i + j];
            }
        }
        System.out.println(bfs());
    }

    // 使用bfs求解

    public static int bfs() {
        //
        LinkedList<int[]> q = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                    q.add(new int[]{
                            i, j
                    });
                }
            }
        }
        // 没有一个感染的 或者全部被感染了
        if (cnt == 0 || cnt == m * n) {
            return -1;
        }
        // 否则就进行bfs
        int v = 2;
        while (!q.isEmpty()) {
            int size = q.size();
            // 找他的邻居
            for (int i = 0; i < size; i++) {
                int[] dir = q.poll();
                int x = dir[0];
                int y = dir[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + move[j];
                    int ny = y + move[j + 1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 0) {
                        grid[nx][ny] = v;
                        q.add(new int[]{
                                nx, ny
                        });
                    }
                }
            }
            v++;
        }
        return v - 3;
    }

}
