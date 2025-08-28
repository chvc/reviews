package od;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-26 07:26:59
 */
public class Od328D {

    static int[][] grid;
    static boolean[][] visited;
    static int n;
    static int m;

    static List<int[]> ans = new ArrayList<>();

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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        List<int[]> paths = new ArrayList<>();
        dfs(grid, 0, 0, paths);
        for (int i = 0; i < ans.size(); i++) {
            int[] pos = ans.get(i);
            System.out.println("(" + pos[0] + "," + pos[1] + ")");
        }
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
