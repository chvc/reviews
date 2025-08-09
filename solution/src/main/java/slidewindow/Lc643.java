package slidewindow;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/27
 */
public class Lc643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (i < k - 1) {
                continue;
            }
            res = Math.max(sum, res);
            sum = sum - nums[i - k+1];

        }
        return (double) res / k;
    }

    public static void main(String[] args) {
        System.out.println(new Lc643().findMaxAverage(new int[]{
                1,12,-5,-6,50,3
        }, 4));
    }
}
