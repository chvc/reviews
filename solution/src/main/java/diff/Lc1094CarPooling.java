package diff;


/**
 * 拼车
 *
 * @author chenghu
 * @since 2025-08-29 21:28:27
 */
public class Lc1094CarPooling {

    static int MAXN = 1003;

    public boolean carPooling(int[][] trips, int capacity) {
        int[] trip = new int[MAXN];
        // 构建差分数组
        for (int i = 0; i < trips.length; i++) {
            // l+v
            // r+1 -v
            int[] t = trips[i];
            int from = t[1];
            trip[from] += t[0];
            int to = t[2];
            trip[to + 1] -= t[0];
            trip[to + 2] -= t[0];
        }
        // 计算前缀和
        for (int i = 1; i < trip.length; i++) {
            trip[i] += trip[i - 1];
        }
        // 再恢复每个的值
        for (int i = 0; i < trip.length; i++) {
            if (trip[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Lc1094CarPooling lc1094 = new Lc1094CarPooling();
        System.out.println(lc1094.carPooling(new int[][]{
                {2, 1, 5}, {3, 5, 7}
        }, 3));
    }


}
