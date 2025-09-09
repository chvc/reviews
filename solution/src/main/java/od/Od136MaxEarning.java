package od;


import javax.lang.model.element.VariableElement;
import java.util.Arrays;
import java.util.Scanner;

/**
 * P00006—最大报酬
 *
 * @author chenghu
 * @since 2025-09-08 22:30:11
 */
public class Od136MaxEarning {

    static int[][] nums;

    static int t;

    static int[][] memo;

    static int[] tt;

    public static void main(String[] args) {
        // 背包问题
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int n = sc.nextInt();
        nums = new int[n + 1][2];
        memo = new int[n + 1][t + 1];

        tt = new int[t+1];
        for (int i = 1; i <= n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            nums[i][0] = w;
            nums[i][1] = v;
        }
        for (int j = 1; j <= n; j++) {
            for (int i = t; i >= 1; i--) {
                int w = nums[j][0];
                int v = nums[j][1];
                int ans = tt[i];
                if (i - w >= 0) {
                    ans = Math.max(ans, tt[i-w] + v);
                }
                tt[i] = ans;
            }
        }
        System.out.println(tt[t]);
    }

    // 在前i个工作中 时间不超过j的情况下 能够获得的最大利润

}
