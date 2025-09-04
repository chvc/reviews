package od;


import javax.lang.model.element.VariableElement;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-05 02:17:01
 */
public class Od305MaxRectangleSum {

    static int n;

    static int m;

    static int[][] grid;

    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) {
        in();
        process();
        out();
    }

    private static void out() {
        System.out.println(max);
    }

    public static void in() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        max = Integer.MIN_VALUE;
    }

    public static void process() {
        // 0-nums.length
        for (int i = 0; i < n; i++) {
            //
            int[] nums = new int[m];
            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    nums[k] += grid[j][k];
                }
                max = Math.max(maxSum(nums), max);
            }
        }
    }

    public static int maxSum(int[] nums) {
        int max = nums[0];
        int pre = max;
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }


}
