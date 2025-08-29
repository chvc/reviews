package od;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * bfs实现
 *
 * @author chenghu
 * @since 2025-08-26 08:37:17
 */
public class Od328MazeProblem {


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

    static List<int[]> ans = new ArrayList<>();

    private static void bfs() {
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
        ans = map.get(posMapping(n - 1, m - 1));
    }


    public static int posMapping(int i, int j) {
        return i * n + j;
    }


    //
    public static void main(String[] args) {
        in();
//        dfs();
        // todo bfs的需要修改 创建了大量的对象 这个不好
        bfs();
        out();
    }

    private static void in() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];
        map.clear();
        ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
    }

    private static void out() {
        for (int i = 0; i < ans.size(); i++) {
            int[] pos = ans.get(i);
            System.out.println("(" + pos[0] + "," + pos[1] + ")");
        }
    }

    public static void dfs() {
        List<int[]> paths = new ArrayList<>();
        dfs(grid, 0, 0, paths);
    }

    public static void dfs(int[][] grid, int i, int j, List<int[]> paths) {
        if (!inArea(i, j)) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (grid[i][j] == 1) {
            return;
        }
        paths.add(new int[]{
                i, j
        });
        if (i == n - 1 && j == m - 1) {
            ans = new ArrayList<>(paths);
            return;
        }
        // 访问当前节点
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newx = move[k] + i;
            int newy = move[k + 1] + j;
            dfs(grid, newx, newy, paths);
        }
        // 还原
        paths.remove(paths.size() - 1);
        visited[i][j] = false;
    }

    public static boolean inArea(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}
