package diff;


/**
 * 1893. 检查是否区域内所有整数都被覆盖
 *
 * @author chenghu
 * @since 2025-08-29 23:02:18
 */
public class Lc1893CheckIfAllTheIntegersInARangeAreCovered {
    static int MAXN = 52;

    public boolean isCovered(int[][] ranges, int left, int right) {

        int[] diff = new int[MAXN];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            diff[range[0]]++;
            diff[range[1] + 1]--;
            max = Math.max(max, range[1]);
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }
        for (int i = left; i <= right; i++) {
            if (diff[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Lc1893CheckIfAllTheIntegersInARangeAreCovered lc1893 = new Lc1893CheckIfAllTheIntegersInARangeAreCovered();
        System.out.println(lc1893.isCovered(new int[][]{
                {1, 10}, {10, 20}
        }, 21, 21));
    }

}
