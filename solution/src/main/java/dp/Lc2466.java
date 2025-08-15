package dp;


import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-15 11:46:22
 */
public class Lc2466 {

    int[] memo;

    public int countGoodStrings(int low, int high, int zero, int one) {
        memo = new int[high + 1];
        Arrays.fill(memo, -1);
        // 当到达i时 要么是 (i-one) + (i-zero)
        int res = 0;
        for (int i = low; i <= high; i++) {
            res += dfs(zero, one, i);
            res = res % 1000000007;
        }
        return res ;
    }

    public int dfs(int zero, int one, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }

        if (i == 0) {
            return 1;
        }
        int ans = dfs(zero, one, i - zero) + dfs(zero, one, i - one);
        ans = ans % 1000000007;
        memo[i] = ans;
        return ans;
        // 当到达i时 要么是 (i-one) + (i-zero)
    }

}
