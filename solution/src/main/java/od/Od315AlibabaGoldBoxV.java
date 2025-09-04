package od;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-04 22:28:12
 */
public class Od315AlibabaGoldBoxV {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(sc.nextLine());
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 进
            sum += nums[i];
            if (i + 1 < k) {
                continue;
            }
            // 统计
            res = Math.max(res, sum);
            // 出
            sum -= nums[i - k + 1];
        }
        System.out.println(res);
    }
}
