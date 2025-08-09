import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/5
 */
public class Lc119 {


    public List<Integer> getRow(int rowIndex) {
        int[][] cache = new int[rowIndex + 1][rowIndex + 1];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(dfs(rowIndex, i, cache));
        }
        return res;
    }

    public int dfs(int i, int j, int[][] cache) {
        // 第i行 第j个
        if (i == j || j == 0) {
            cache[i][j] = 1;
            return 1;
        }
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        cache[i][j] = dfs(i - 1, j - 1, cache) + dfs(i - 1, j, cache);
        return cache[i][j];
    }

    public static void main(String[] args) {
        Lc119 lc119 = new Lc119();
        System.out.println(lc119.getRow(5));
    }

}
