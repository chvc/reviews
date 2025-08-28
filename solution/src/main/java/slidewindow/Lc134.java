package slidewindow;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-28 00:22:03
 */
public class Lc134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        //
        int n = gas.length;
        // [l..r)

        for (int l = 0, r = l; l < n; l = r + 1, r = l) {
            int sum = 0;
            while (r < n && sum + gas[r % n] - cost[r % n] >= 0) {
                sum +=  (gas[r % n] - cost[r % n]); // 如果没有超出范围
                if (r - l + 1 == n) {
                    return l;
                }
                r++;
            }
        }
        return -1;
    }

}
