package od.exam.c;


import java.util.Scanner;

/**
 * P00335—农场施肥/不爱施肥的小布
 *
 * @author chenghu
 * @since 2025-08-25 21:46:17
 */
public class Od197FertilizationFarm {
    static int[] fields;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        fields = new int[m];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            fields[i] = scanner.nextInt();
            max = Math.max(max, fields[i]);
        }

        int l = 1;
        int r = max;
        int ans = 0;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (f(mid) <= n) {
                // 说明满足了条件 还有可以缩小的空间的
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ans == 0 ? -1 : ans);

    }

    public static int f(int speed) {
        int time = 0;
        for (int i = 0; i < fields.length; i++) {
            time += (fields[i] + speed - 1) / speed;
        }
        return time;
    }

}
