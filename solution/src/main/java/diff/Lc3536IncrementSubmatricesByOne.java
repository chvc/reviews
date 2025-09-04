package diff;


import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-02 20:38:07
 */
public class Lc3536IncrementSubmatricesByOne {


    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 2][n + 2];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];
            diff(diff, r1 + 1, c1 + 1, r2 + 1, c2 + 1);
        }
        // 求 累加和
        int[][] res = new int[n][n];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                diff[i][j] += diff[i][j - 1] + diff[i - 1][j] - diff[i - 1][j - 1];
                res[i - 1][j - 1] = diff[i][j];
            }
        }
        return res;
    }

    public void diff(int[][] diff, int a, int b, int c, int d) {
        // （a,b） (c,d)
        diff[a][b] += 1;
        diff[c + 1][b] -= 1;
        diff[a][d + 1] -= 1;
        diff[c + 1][d + 1] += 1;
    }

    public static void main(String[] args) {
        Lc3536IncrementSubmatricesByOne lc3536IncrementSubmatricesByOne = new Lc3536IncrementSubmatricesByOne();
        System.out.println(Arrays.deepToString(lc3536IncrementSubmatricesByOne.rangeAddQueries(3, new int[][]{
                {1,1,2,2}, {0,0,1,1}
        })));
    }


}
