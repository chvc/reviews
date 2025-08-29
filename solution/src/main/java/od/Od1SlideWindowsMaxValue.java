package od;


import java.util.Scanner;

/**
 * P00337- 滑动窗口最大值-滑动窗口
 *
 * @author chenghu
 * @since 2025-08-10 10:51:44
 */
public class Od1SlideWindowsMaxValue {

    static int[] nums;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int windowsLength = scanner.nextInt();
            int sum = 0;
            int ans = Integer.MIN_VALUE;
            // windows 窗口长度 3 前两个数 到第三个数开始数
            for (int i = 0; i < nums.length; i++) {
                // 加入
                sum += nums[i];
                // 3 0,1 未形成窗口
                if (i < windowsLength - 1) {
                    continue;
                }
                // 更新答案
                ans = Math.max(ans, sum);
                // 移除 最左边的元素 i=3  left=0 i-left+1 = len
                sum -= nums[i - windowsLength + 1];
            }
            System.out.println(ans);
        }
    }


}
