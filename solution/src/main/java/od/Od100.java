package od;


import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-25 21:55:11
 */
public class Od100 {

    static int[] nums;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();

        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // 进窗口
            sum += nums[i];
            if (i < m - 1) {
                continue;
            }
            // 统计结果
            ans = Math.max(ans, sum);
            // 出窗口
            sum -= nums[i - m + 1];
        }
        System.out.println(ans);

    }
}
