package grid;


import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-16 10:15:53
 */
public class Lc1162 {

    int n;

    int m;

    boolean[][] visited;
    // x y  x-1 y x+nums[i] y+ nums[i+1]
    // x y  x y+1
    // x y  x+1 y
    // x y  x   y-1
    int[] move = new int[]{-1, 0, 1, 0, -1};


    public int maxDistance(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        int land = 0;

        Queue<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 将陆地加到队列中去
                if (grid[i][j] == 1) {
                    Integer[] xy = new Integer[2];
                    xy[0] = i;
                    xy[1] = j;
                    queue.add(xy);
                    visited[i][j] = true;
                    land++;
                }
            }
        }
        if (land == 0 || land == m * n) {
            return -1;
        }
        //
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer[] pos = queue.poll();
                Integer x = pos[0];
                Integer y = pos[1];

                // 看上下左右四个方向 如果是海洋 那么就加进来
                for (int j = 0; j < 4; j++) {
                    int newx = x + move[j];
                    int newy = y + move[j + 1];
                    if (newx >= 0 && newx < n && newy >= 0 && newy < m && grid[newx][newy] == 0 && !visited[newx][newy]) {
                        Integer[] xy = new Integer[2];
                        xy[0] = newx;
                        xy[1] = newy;
                        visited[newx][newy] = true;
                        queue.add(xy);
                    }
                }
            }
            level++;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Lc1162 lc1162 = new Lc1162();
        System.out.println(lc1162.maxDistance(new int[][]{
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 0, 1, 1, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 1, 1, 1, 0, 0, 1},
                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {1, 1, 0, 1, 1, 1, 1, 1, 0, 0}
        }));
    }

}
