package od;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *  bfs实现
 *
 * @author chenghu
 * @since 2025-08-26 08:37:17
 */
public class Od328B {


    static int[][] grid;
    static boolean[][] visited;
    static int n;
    static int m;
    static Map<Integer, List<int[]>> map = new HashMap<>();

    // x-1 y
    // x y+1
    // x+1 y
    // x y-1
    static int[] move = new int[]{-1, 0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];
        map.clear();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        LinkedList<int[]> queue = new LinkedList<>();
        int[] firstPos = {0, 0};
        queue.add(firstPos);
        List<int[]> firstPath = new ArrayList<>();
        firstPath.add(firstPos);
        map.put(posMapping(0, 0), firstPath);
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] dic = queue.poll();
            int x = dic[0];
            int y = dic[1];
            List<int[]> pathList = map.get(posMapping(x, y));
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 4; j++) {
                    int newx = move[j] + x;
                    int newy = move[j + 1] + y;
                    // 才能加进来
                    if (newx < n && newx >= 0 && newy < m && newy >= 0 && !visited[newx][newy] && grid[newx][newy] == 0) {
                        int[] pos = {newx, newy};
                        List<int[]> curPath = new ArrayList<>(pathList);
                        queue.add(pos);
                        curPath.add(pos);
                        map.put(posMapping(newx, newy), curPath);
                        visited[newx][newy] = true;
                    }
                }
            }
        }
        List<int[]> paths = map.get(posMapping(n - 1, m - 1));
        for (int i = 0; i < paths.size(); i++) {
            int[] pos = paths.get(i);
            System.out.println("(" + pos[0] + "," + pos[1] + ")");
        }
    }

    public static int posMapping(int i, int j) {
        return i * n + j;
    }
}
