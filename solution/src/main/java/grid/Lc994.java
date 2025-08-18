package grid;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/16
 */
public class Lc994 {

    int n;
    int m;
    boolean[][] visited;

    // x y x-1 y 上
    // x y+1    右
    // x+1 y    下
    // x y-1     左
    int[] move = new int[]{
            -1, 0, 1, 0, -1
    };

    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        // 先遍历一遍 查一下有多少个空白格子
        int orangeSize = 0;
        int blankSize = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    blankSize++;
                }
                if (grid[i][j] == 2) {
                    orangeSize++;
                    Integer[] arr = new Integer[2];
                    arr[0] = i;
                    arr[1] = j;
                    visited[i][j] = true;
                    queue.add(arr);
                }

            }
        }
        // 根本没有橘子 返回 -1;
        if (blankSize == n * m) {
            return -1;
        }
        // 全是烂橘子
        if (orangeSize == n * m) {
            return 0;
        }
        int min = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 从四个方向扩展
                Integer[] orange = queue.poll();
                Integer x = orange[0];
                Integer y = orange[1];
                for (int j = 0; j < 4; j++) {
                    int newx = x + move[j];
                    int newy = y + move[j + 1];
                    // 不越界 并且没有被访问 并且是新鲜橘子
                    if (newx >= 0 && newx < n && newy >= 0 && newy < m && !visited[newx][newy] && grid[newx][newy] == 1) {
                        // 加入到队列中去
                        Integer[] pos = new Integer[]{
                                newx, newy
                        };
                        queue.add(pos);
                        visited[newx][newy] = true;
                    }
                }
            }
            min++;
        }
        return min - 1;
    }
}
