package od;


import java.util.Map;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-26 23:30:45
 */
public class Od176 {

    static int[] nums;

    static int ans;

    static int target;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        ans = 0;
        target = sc.nextInt();
        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int i, int sum) {
        //
        if (i == nums.length) {
            ans = Math.max(ans, sum);
            return;
        }
        // 第i个不要
        dfs(i + 1, sum);
        // 如果 超过了 target 那么就不能要
        if (nums[i] > target - sum) {
            return;
        }
        // 第i个要
        sum = sum + nums[i];
        dfs(i + 1, sum);
        sum = sum - nums[i];
    }
}
