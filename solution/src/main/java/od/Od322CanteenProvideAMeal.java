package od;


import java.util.Scanner;

/**
 * #P00012—食堂供餐
 *
 * @author chenghu
 * @since 2025-09-25 12:29:34
 */
public class Od322CanteenProvideAMeal {

    static int[] nums;
    static int n;
    static int rest;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        rest = sc.nextInt();
        nums = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            nums[i] = x;
            max += x;
        }
        //
        int min = 0;
        // 二分搜索
        int ans = 0;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            // 二分答案法  如果 当前供餐速度ok的话 那就缩小答案的范围
            if (ok(mid, rest)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean ok(int speed, int rest) {
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x > rest) {
                return false;
            }
            rest = rest - x + speed;
        }
        return true;
    }

}
