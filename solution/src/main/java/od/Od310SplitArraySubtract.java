package od;


import java.util.Scanner;

/**
 * #P00223—分割数组的最大差值
 *
 * @author chenghu
 * @since 2025-09-23 21:25:06
 */
public class Od310SplitArraySubtract {

    /**
     * 给定一个由若干整数组成的数组nums ，可以在数组内的任意位置进行分割，将该数组分割成两个非空子数组(即左数组和右数组)，分别对子数组求和得到两个值，计算这两个值的差值，请输出所有分割方案中，差值最大的值。
     * 输入描述
     * 第一行输入数组中元素个数n，1 < n <= 100000
     * <p>
     * 第二行输入数字序列，以空格进行分隔，数字取值为4字节整数
     * 输出描述
     * 输出差值的最大取值
     * 示例1：
     * 输入：
     * 6
     * 1 -2 3 4 -9 7
     * <p>
     * 输出：
     * 10
     * <p>
     * 说明：
     * 将数组 nums 划分为两个非空数组的可行方案有:左数组 = [1] 且 右数组 = [-2,3,4,-9,7]，和的差值 = |1 - 3|=2
     * 左数组 = [1,-2] 且 右数组 = [3,4,-9,7]，和的差值 =| -1-5 |=6
     * 左数组 =[1,-2,3,1] 且 右数组 =[4,-9,7]，和的差值 =|2 - 2|=0
     * 左数组 =[1,-2,3,4] 且右数组=[-9,7]，和的差值 =|6 -(-2)| = 8,
     * 左数组 =[1,-2,3,4,-9] 且 右数组 = [7]，和的差值 =|-3-7| = 10最大的差值为10
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        long[] prefix = new long[n + 1];
        prefix[0] = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            sum += x;
            prefix[i + 1] = prefix[i] + x;
        }
        // 求出了前缀和 再来分割数组
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            long x = sum - prefix[i + 1];
            long abs = Math.abs(x - prefix[i + 1]);
            ans = Math.max(ans,abs);
        }
        System.out.println(ans);
    }

}
