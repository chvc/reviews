package dp;


import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-09 20:34:16
 */
public class Lc91 {

    int ans = 0;
    int[] memo;

    public int numDecodings(String s) {
        //
        char[] chars = s.toCharArray();
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return dfs(chars, 0);
    }

    public int dfs(char[] chars, int i) {
        if (i == chars.length) {
            return 1;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int ans;
        if (chars[i] == '0') {
            ans = 0;
        } else {
            ans = dfs(chars, i + 1);
            if (i + 1 < chars.length && ((chars[i] - '0') * 10 + (chars[i + 1] - '0')) < 26) {
                ans += dfs(chars, i + 2);
            }
        }
        memo[i] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Lc91 lc91 = new Lc91();
        System.out.println(lc91.numDecodings("27"));
    }

}
