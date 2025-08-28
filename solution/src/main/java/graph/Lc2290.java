package graph;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-28 07:29:06
 */
public class Lc2290 {

    // 01 bfs 障碍物是1 空地是0
    // 01bfs 要点 维护一个距离表 如果 代表到源点的距离
    // 第一个点的距离默认是0 其他默认为正无穷
    // 如果来到的这个路径 来源到当前点的 比instance要小 更新instance 如果是0 加入队首 如果是1 加入队尾


    /**
     * 给你一个下标从 0 开始的二维整数数组 grid ，数组大小为 m x n 。每个单元格都是两个值之一：
     * 0 表示一个 空 单元格，
     * 1 表示一个可以移除的 障碍物 。
     * 你可以向上、下、左、右移动，从一个空单元格移动到另一个空单元格。
     * 现在你需要从左上角 (0, 0) 移动到右下角 (m - 1, n - 1) ，返回需要移除的障碍物的 最小 数目。
     */

    //

    // x-1 y
    // x y+1
    // x+1 y
    // x y-1
    static int[] move = new int[]{-1, 0, 1, 0, -1};
    static int[][] instance;
    static int n;
    static int m;

    public static void build() {
        instance = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(instance[i], Integer.MAX_VALUE);
        }
    }

    public int minimumObstacles(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        build();
        // 准备一个双端队列
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[]{0, 0});
        instance[0][0] = 0;
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int x = cur[0];
            int y = cur[1];
            if (x == n - 1 && y == m - 1) {
                return instance[x][y];
            }
            // 邻居
            for (int i = 0; i < 4; i++) {
                int newX = x + move[i];
                int newY = y + move[i + 1];
                // 如果不越界 并且距离变小的话 处理逻辑
                if (newX < n && newY < m && newX >= 0 & newY >= 0 && instance[x][y] + grid[newX][newY] < instance[newX][newY]) {
                    // 更新距离
                    instance[newX][newY] = instance[x][y] + grid[newX][newY];
                    if (grid[newX][newY] == 0) {
                        deque.addFirst(new int[]{
                                newX, newY
                        });
                    } else {
                        deque.addLast(new int[]{
                                newX, newY
                        });
                    }
                }
            }
        }
        return -1;
    }

}
