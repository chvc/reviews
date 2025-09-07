package dp;


import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-07 21:16:11
 */
public class Lc13121MinimumInsertionStepsToMakeAStringPalindrome {

    static int[][] dp;

    public int minInsertions(String s) {
        // l..r 之间进行dp
        char[] chars = s.toCharArray();
        dp = new int[chars.length][chars.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(chars, 0, chars.length - 1);
    }

    public static int f(char[] s, int l, int r) {
        // 一个字符 天然回文
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        if (l == r) {
            return 0;
        }
        // 两个字符 如果相等就是回文 否则代价是1
        if (l + 1 == r) {
            return s[l] == s[r] ? 0 : 1;
        }
        // 剩下的 abcb
        int ans;
        if (s[l] == s[r]) {
            // 如果两端的相等 那么就是
            ans = f(s, l + 1, r - 1);
        } else {
            ans = Math.min(f(s, l + 1, r), f(s, l, r - 1)) + 1;
        }
        dp[l][r] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Lc13121MinimumInsertionStepsToMakeAStringPalindrome lc = new Lc13121MinimumInsertionStepsToMakeAStringPalindrome();
        System.out.println(lc.minInsertions("mbadm"));
    }

}
