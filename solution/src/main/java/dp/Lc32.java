package dp;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-20 21:23:30
 */
public class Lc32 {


    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        // (()) dp[i] 以i结尾的最长的有效括号的长度
        // ) ( ) ( ) )
        // 0 1 2 3 4 5
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            // 左括号 一定无法结尾
            if (s.charAt(i) == ')') {
                // 如果是右括号 那么就看dp[i-1]的跳转的p位置是啥
                int p = i - dp[i - 1] - 1;
                if (p >= 0 && s.charAt(p) == '(') {
                    if (p - 1 >= 0) {
                        dp[i] = dp[i - 1] + 2 + dp[p - 1];
                        ans = Math.max(ans, dp[i]);
                    } else {
                        dp[i] = dp[i - 1] + 2;
                        ans = Math.max(ans, dp[i]);
                    }
                }
            }
        }
        return ans;
    }

}
