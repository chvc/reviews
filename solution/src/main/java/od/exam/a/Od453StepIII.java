package od.exam.a;



import java.util.Scanner;

/**
 * P00135—跳格子3
 *
 * @author chenghu
 * @since 2025-09-04 00:48:50
 */
public class Od453StepIII {

    static int[] nums;

    static Integer[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        memo = new Integer[n + 1];
        int k = sc.nextInt();
        int f = f(n - 1, k);
        System.out.println(f);
    }

    public static int f(int x, int k) {
        if (x == 0) {
            return nums[0];
        }
        if (memo[x] != null) {
            return memo[x];
        }

        int res = nums[x];
        for (int i = 1; i <= k; i++) {
            if (x - i >= 0) {
                res = Math.max(res, f(x - i, k) + res);
            }
        }
        memo[x] = res;
        return res;
    }
}
