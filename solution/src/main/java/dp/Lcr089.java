package dp;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/26
 */
public class Lcr089 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            // 当前如果打劫的话 那就是说 加上前 n-2家的最大值 当前不打 就是说前n-1家的值比较大
            dp[i] = Math.max(dp[i-1], dp[i - 2] + nums[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        System.out.println(new Lcr089().rob(new int[]{
                2,7,9,3,1
        }));
    }

}
