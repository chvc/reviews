package od;


import java.util.Arrays;
import java.util.Scanner;

/**
 *  P00159—补种未成活胡杨
 *
 * @author chenghu
 * @since 2025-09-04 21:17:11
 */
public class Od296ReplantPopulusEuphratica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        for (int i = 0; i < m; i++) {
            nums[sc.nextInt() - 1] = 0;
        }
        int k = sc.nextInt();
        // 滑动窗口
        int count = 0;
        int ans = 0;
        for (int r = 0, l = 0; r < n; r++) {
            if (nums[r] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[l] == 0) {
                    count--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        System.out.println(ans);
    }
}
