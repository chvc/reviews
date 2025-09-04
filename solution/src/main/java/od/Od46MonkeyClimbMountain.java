package od;


import java.util.Scanner;

/**
 * P00134—猴子爬山
 *
 * @author chenghu
 * @since 2025-09-04 00:27:57
 */
public class Od46MonkeyClimbMountain {
    /**
     * 一天一只顽猴想去从山脚爬到山顶，途中经过一个有个N个台阶的阶梯，但是这猴子有一个习惯：
     * 每一次只能跳1步或跳3步，试问猴子通过这个阶梯有多少种不同的跳跃方式？
     * 输入描述
     * 输入只有一个整数N（0<N<=50）此阶梯有多少个台阶。
     * 输出描述
     * 输出有多少种跳跃方式（解决方案数）。
     * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
     * 输入
     * 50
     * 输出
     * 122106097
     * 示例2 输入输出示例仅供调试，后台判题数据一般不包含示例
     * 输入
     * 3
     * 输出
     * 2
     */

    static long[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int steps = sc.nextInt();
        memo = new long[steps + 1];
        System.out.println(f(steps));
    }

    public static long f(int step) {
        if (step < 0) {
            return 0;
        }
        if (memo[step] != 0) {
            return memo[step];
        }

        if (step == 1) {
            return 1;
        }
        if (step == 3) {
            return 2;
        }
        memo[step] = f(step - 1) + f(step - 3);
        return memo[step];
    }


}
