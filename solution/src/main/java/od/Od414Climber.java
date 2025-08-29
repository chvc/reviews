package od;

import java.util.Scanner;

/**
 *  P00317—攀登者1
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Od414Climber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strs = line.split(",");
        int[] nums = new int[strs.length];
        int i = 0;
        for (String str : strs) {
            nums[i] = Integer.parseInt(str);
            i++;
        }
        int cnt = findTopCount(nums);
        System.out.println(cnt);
    }

    public static int findTopCount(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    cnt++;
                }
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) {
                    cnt++;
                }
            } else {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }


}

