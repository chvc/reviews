package diff;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-29 23:29:46
 */
public class Lc1854MaximumPopulationYear {

    int maxn = 101;
    int start = 1949;

    public int maximumPopulation(int[][] logs) {
        int[] diff = new int[maxn];
        for (int i = 0; i < logs.length; i++) {
            int[] log = logs[i];
            diff[log[0] - start]++;
            diff[log[1] - start]--;
        }
        // 构建前缀和
        int max = 0;
        int startYear = 0;
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
            if (diff[i] > max) {
                max = diff[i];
                startYear = i;
            }
        }
        return startYear + start;
    }

}
