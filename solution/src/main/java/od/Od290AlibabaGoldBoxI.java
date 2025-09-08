package od;


import java.util.Arrays;
import java.util.Scanner;

/**
 * #P00187—阿里巴巴找黄金宝箱I
 *
 * @author chenghu
 * @since 2025-09-08 09:20:11
 */
public class Od290AlibabaGoldBoxI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        int[] suffixSum = new int[n + 1];
        prefixSum[0] = 0;
        suffixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int x = n - i;
            suffixSum[x] = suffixSum[x-1] + nums[i];
        }
        // 遍历
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            int suf = n - i - 1;
            if (prefixSum[i] == suffixSum[suf]) {
                ans = i;
                System.out.println(ans);
                return;
            }
        }
        System.out.println(ans);
    }
}
