package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * #P00242. 华为od机试—求解连续数列
 *
 * @author chenghu
 * @since 2025-09-27 15:48:11
 */
public class Od194SolveTheConsecutiveSequence {

    /**
     * 已知连续正整数数列{K}=K1,K2,K3…Ki的各个数相加之和为S，i=N (0<S<100000, 0<N<100000), 求此数列K。
     * <p>
     * 输入描述
     * <p>
     * 输入包含两个参数，1）连续正整数数列和S，2）数列里数的个数N。
     * <p>
     * 输出描述
     * <p>
     * 如果有解输出数列K，如果无解输出-1。
     * <p>
     * 示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
     * <p>
     * 输入
     * <p>
     * 525 6
     * <p>
     * 输出
     * <p>
     * 85 86 87 88 89 90
     * <p>
     * 示例2  输入输出示例仅供调试，后台判题数据一般不包含示例
     * <p>
     * 输入
     * <p>
     * 3 5
     * <p>
     * 输出
     * <p>
     * -1
     */

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int a = 2 * s - n * n + n;
        int b = 2 * n;
        int ans = -1;
        if (a % b != 0) {
            System.out.println(ans);
            return;
        }
        ans = a / b;
        if (ans <= 0) {
            System.out.println(-1);
            return;
        }
        int[] nums = new int[n];
        nums[0] = ans;
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i - 1] + 1;
        }
        System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int num;
        List<Integer> result = new ArrayList<>();
        if (2 * s % n != 0) {
            System.out.print(-1);
        } else if ((2 * s / n - n) % 2 == 0) {
            System.out.print(-1);
        } else {
            num = (2 * s / n + 1 - n) / 2;
            for (int i = 0; i < n; i++) {
                result.add(num + i);
            }
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i != result.size() - 1) {
                    System.out.print(' ');
                }
            }
        }


    }

}
