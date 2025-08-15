package grid;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-15 00:16:56
 */
public class Ms1619 {

    int m;
    int n;
    List<Integer> ans = new ArrayList<>();

    public int[] pondSizes(int[][] land) {
        m = land.length;
        n = land[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    int area = dfs(land, i, j);
                    ans.add(area);
                }
            }
        }
        Collections.sort(ans);
        return ans.stream().mapToInt(a -> a).toArray();
    }

    public int dfs(int[][] land, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || land[i][j] != 0) {
            return 0;
        }
        land[i][j] = -1;
        return 1 + dfs(land, i + 1, j)
                + dfs(land, i - 1, j)
                + dfs(land, i, j + 1)
                + dfs(land, i, j - 1)
                + dfs(land, i + 1, j - 1)
                + dfs(land, i + 1, j + 1)
                + dfs(land, i - 1, j - 1)
                + dfs(land, i - 1, j + 1);
    }

}
