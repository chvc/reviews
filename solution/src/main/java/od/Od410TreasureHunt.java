package od;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-05 06:19:10
 */
public class Od410TreasureHunt {

    // x-1 y
    // x y+1
    // x+1 y
    // x y-1
    static int[] move = new int[]{-1, 0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{
                0, 0
        });
        visited[0][0] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            // 向四个方向移动
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] dic = queue.poll();
                int x = dic[0];
                int y = dic[1];
                count++;
                for (int a = 0; a < 4; a++) {
                    int nx = x + move[a];
                    int ny = y + move[a + 1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && (digit(nx, ny) <= k)) {
                        queue.add(new int[]{
                                nx, ny
                        });
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static int digit(int i, int j) {
        int ans = 0;
        while (i != 0 || j != 0) {
            int mod = i % 10;
            i = i / 10;
            int modj = j % 10;
            j = j / 10;
            ans += mod + modj;
        }
        return ans;
    }

}
