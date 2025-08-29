package od.exam.b;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  P00154—战场索敌
 *
 * @author chenghu
 * @since 2025-08-20 23:08:39
 */
public class Od319BattlefieldReconnaissance {
    static int n;
    static int m;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] param = line.split(" ");
            n = Integer.parseInt(param[0]);
            m = Integer.parseInt(param[1]);
            int k = Integer.parseInt(param[2]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                grid[i] = reader.readLine().toCharArray();
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] != '#') {
                        int dfs = dfs(grid, i, j);
                        if (dfs < k) {
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '#') {
            return 0;
        }
        int ans = 0;
        char temp = grid[i][j];
        if (temp == 'E') {
            ans = ans + 1;
        }
        grid[i][j] = '#';
        ans += dfs(grid, i - 1, j);
        ans += dfs(grid, i + 1, j);
        ans += dfs(grid, i, j - 1);
        ans += dfs(grid, i, j + 1);
        return ans;
    }

}
