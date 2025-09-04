package od;


import java.util.Arrays;
import java.util.Scanner;

/**
 * P00081—体育场找座位
 *
 * @author chenghu
 * @since 2025-09-05 05:19:09
 */
public class Od330FindSeats {

    static int[] nums;


    public static void main(String[] args) {
        input2();
        //
        cal();

    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public static void input2() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            nums[i] = s.charAt(i) - '0';
        }
    }

    public static void cal() {
        if (nums.length == 1) {
            System.out.println(nums[0] == 1 ? 0 : 1);
            return;
        }
        if (nums.length == 2) {
            // 两个座位
            if (nums[0] == 0 || nums[1] == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }
        // 从0..i-1
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] == 0 && nums[i + 1] == 0) {
                    count++;
                    nums[i] = 1;
                }
            } else if (i == nums.length - 1) {
                if (nums[i] == 0 && nums[i - 1] == 0) {
                    count++;
                    nums[i] = 1;
                }
            } else {
                if (nums[i] == 0 && nums[i - 1] == 0 && nums[i + 1] == 0) {
                    count++;
                    nums[i] = 1;
                }
            }
        }
        System.out.println(count);
    }


}
