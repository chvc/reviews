package slidewindow;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/26
 */
public class Lc3 {

    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        // 左闭右开
        int res = 0;
        int[] feq = new int[256];
        while (l < s.length()) {
            char c = s.charAt(r);
            if (r + 1 <= s.length() && feq[c] == 0) {
                feq[c]++;
                r++;
            } else {
                feq[s.charAt(l)]--;
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }

    public static void main(String[] args) {

    }


}
