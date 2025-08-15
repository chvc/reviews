package greedy;


import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-14 22:19:09
 */
public class Lc1833 {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cnt = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins < costs[i]) {
                break;
            }
            coins = coins - costs[i];
            cnt++;
        }
        return cnt;
    }


}
