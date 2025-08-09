package dp;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/28
 */
public class Lc53 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        // dp 前n项数组的最大和
        // dp(n) = if(dp[n-1]<0 , nums[i] ) else dp[n-1] + nums[i]
        dp[0] = Math.max(Integer.MIN_VALUE, nums[0]);
        int res = Math.max(dp[0], Integer.MIN_VALUE);
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + dp[i - 1];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Lc53().maxSubArray(new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        }));
    }

}
