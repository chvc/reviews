package od;


import java.util.Arrays;
import java.util.Scanner;

/**
 * P00224—生日礼物-二分搜索
 *
 * @author chenghu
 * @since 2025-9-25 22:48:22
 */
public class Od321GiftForBirthday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cakes = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] gifts = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(sc.nextLine());
        System.out.println(f1(gifts, cakes, x));
    }

    public static int f1(int[] gifts, int[] cakes, int x) {
        int ans = 0;
        Arrays.sort(gifts);
        for (int cake : cakes) {
            if (cake < x) {
                int i = search(gifts, x - cake);
                ans += i+1;
            }
        }
        return ans;
    }

    public static int search(int[] gifts, int target) {
        int ans = -1;
        int l = 0;
        int r = gifts.length - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (gifts[mid] <= target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

}
