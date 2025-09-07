package od;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-04 20:49:54
 */
public class Od437GreedySinger {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int travelTime = 0;
        for (int i = 0; i <= n; i++) {
            travelTime += sc.nextInt();
        }
        // n个城市 // 说明一共有n行了
        int m = t - travelTime;
        List<List<Integer>> bags = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 组建一下数据
            int start = sc.nextInt();
            int d = sc.nextInt();
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                int v = Math.max(start - d * j, 0);
                tmp.add(v);
            }
            bags.add(tmp);
        }
        int i = groupedBag(bags, bags.size(), m);
        System.out.println(i);
    }

    public static int groupedBag(List<List<Integer>> bags, int n, int m) {
        // 在前 [i][j] 前i个背包中选取数量不超过j所能带来的最大的收益
        int[][] dp = new int[n+1][m + 1];
        // 要么当前不选 要么当前选
        // 前i组背包
        for (int i = 1; i <= n; i++) {
            // 容量为j
            // 加工前缀和
            List<Integer> bag = bags.get(i - 1);
            int[] prefix = new int[bag.size() + 1];
            for (int j = 0; j < bag.size(); j++) {
                prefix[j + 1] = prefix[j] + bag.get(j);
            }
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                // 如果选当前背包
                for (int k = 1; k <= Math.min(j,bag.size()); k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k] + prefix[k]);
                }
            }
        }
        return dp[n][m];
    }

}
