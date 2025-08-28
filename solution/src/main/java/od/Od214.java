package od;


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-21 00:25:49
 */
public class Od214 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int sum = scanner.nextInt();
            int n = scanner.nextInt();
            int[] bucketBalls = new int[n];
            for (int i = 0; i < n; i++) {
                bucketBalls[i] = scanner.nextInt();
            }
            int ballSum = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < bucketBalls.length; i++) {
                ballSum += bucketBalls[i];
                max = Math.max(max, bucketBalls[i]);
            }
            if (ballSum <= sum) {
                System.out.println("[]");
            }
            // 设置 maxCapacity
            // 0 -- max
            int left = 0;
            int right = max;
            int cap = -1;
            while (left <= right) {
                int m = left + (right - left) / 2;
                // 可能是一个答案
                int s = 0;
                int pick = 0;
                for (int i = 0; i < bucketBalls.length; i++) {
                    s += bucketBalls[i];
                    pick += bucketBalls[i] > m ? bucketBalls[i] - m : 0;
                }
                if (s - pick <= sum) {
                    // 这个值可以选 但是可能有更合适的 可能取出的比较多 也就是说可以往右边收缩
                    cap = m;
                    left = m + 1;
                } else {
                    // 取出的少了 也就是 cap大了 所以要缩小范围
                    right = m - 1;
                }
            }
            int[] res = new int[n];
            for (int i = 0; i < res.length; i++) {
                res[i] = bucketBalls[i] > cap ? bucketBalls[i] - cap : 0;
            }
            String s = Arrays.stream(res).boxed().map(String::valueOf).collect(Collectors.joining(","));
            System.out.println("[" + s + "]");
        }
    }


}
