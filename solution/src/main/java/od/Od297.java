package od;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-26 21:11:58
 */
public class Od297 {

    static int[] arr;
    static int[] preSum;

    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        arr = new int[n];
        preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        while (right < arr.length && left < arr.length) {
            if (sum < x) {
                sum += arr[right];
                right++;
            } else {
                // 统计个数
                count += arr.length - right + 1;
                sum -= arr[left];
                left++;
            }
        }
        System.out.println(count);

    }


}
