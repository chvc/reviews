package od;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-03 23:19:48
 */
public class Od261MostTeam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Arrays.sort(nums);
        // 初始化左右指针
        int l = 0;
        int r = nums.length - 1;
        int count = 0;
        while (l <= r) {
            if (l == r) {
                if (nums[r] >= k) {
                    r--;
                    count++;
                }
            } else {
                if (nums[r] >= k) {
                    r--;
                    count++;
                    continue;
                }
                if (nums[r] + nums[l] < k) {
                    l++;
                } else {
                    l++;
                    r--;
                    count++;
                }
            }

        }
        System.out.println(count);
    }

}
