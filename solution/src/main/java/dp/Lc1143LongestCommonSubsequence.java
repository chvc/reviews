package dp;


/**
 * 最长公共子序列
 *
 * @author chenghu
 * @since 2025-09-11 22:20:22
 */
public class Lc1143LongestCommonSubsequence {


    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return f(s1, s2, n, m, dp);
    }

    public int f(char[] s1, char[] s2, int len1, int len2, int[][] dp) {
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        if (dp[len1][len2] != -1) {
            return dp[len1][len2];
        }
        int p1 = f(s1, s2, len1 - 1, len2 - 1, dp);
        int p2 = f(s1, s2, len1, len2 - 1, dp);
        int p3 = f(s1, s2, len1 - 1, len2, dp);
        int p4;
        if (s1[len1 - 1] == s2[len2 - 1]) {
            p4 = f(s1, s2, len1 - 1, len2 - 1, dp) + 1;
        } else {
            p4 = p1;
        }
        dp[len1][len2] = Math.max(p1, Math.max(p2, Math.max(p3, p4)));
        return dp[len1][len2];
    }
}
