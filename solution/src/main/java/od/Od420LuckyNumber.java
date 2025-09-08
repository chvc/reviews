package od;


import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-08 15:16:52
 */
public class Od420LuckyNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1 || n > 100) {
            System.out.println(12345);
            return;
        }
        int lucky = sc.nextInt();
        if (lucky < -100 || lucky > 100) {
            System.out.println(12345);
            return;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x < -100 || x > 100) {
                System.out.println(12345);
                return;
            }
            nums[i] = x;
        }

        int pos = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int offset = nums[i];
            if (lucky != 0) {
                if (nums[i] == lucky) {
                    offset = offset < 0 ? offset - 1 : offset + 1;
                }
            } else {
                if (offset == 0) {
                    System.out.println(12345);
                    return;
                }
            }
            pos = pos + offset;
            ans = Math.max(ans, pos);
        }
        System.out.println(ans);
    }
}
