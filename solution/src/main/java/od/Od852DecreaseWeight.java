package od;


import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-08 23:37:41
 */
public class Od852DecreaseWeight {

    static int[] nums;

    static int ans;

    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        k = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        dfs(0, 0, t);
        System.out.println(ans);
    }

    //当前选择i
    public static void dfs(int i, int cnt, int target) {
        // 已经选了1个 选两个 选三个
        if (cnt > k || target < 0) {
            return;
        }
        if (i >= nums.length) {
            return;
        }
        if (cnt == k) {
            if (target == 0) {
                ans++;
            }
            return;
        }

        dfs(i + 1, cnt, target);
        dfs(i + 1, cnt + 1, target - nums[i]);
    }

}
