package slidewindow;


import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-15 20:16:40
 */
public class Lc2090 {
    public int[] getAverages(int[] nums, int k) {
        int[] avgs = new int[nums.length];
        Arrays.fill(avgs, -1);
        long sum = 0;
        int len = 2 * k + 1;
        for (int i = 0; i < nums.length; i++) {
            // 进
            sum += nums[i];
            if (len - i > 1) {
                continue;
            }
            // 更新
            avgs[(i + i - len + 1) / 2] = (int) (sum / len);
            // 出
            sum -= nums[i - len + 1];
        }
        return avgs;
    }

    public static void main(String[] args) {
        Lc2090 lc2090 = new Lc2090();
        System.out.println(Arrays.toString(lc2090.getAverages(new int[]{
                7, 4, 3, 9, 1, 8, 5, 2, 6
        }, 3)));
    }

}
