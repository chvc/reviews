package slidewindow;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/29
 */
public class Lc1750 {
    public int minimumLength(String s) {
        // 前缀 后缀
        int l = 0;
        int r = s.length() - 1;
        int res = s.length();
        while (l < r) {
            char pre = s.charAt(l);
            char suf = s.charAt(r);
            if (pre != suf) {
                res = Math.min(res, r - l + 1);
                break;
            }
            while (pre == s.charAt(l)) {
                l++;
            }
            while (suf == s.charAt(r)) {
                r--;
            }
        }
        res = Math.min(res, r - l + 1);
        return Math.max(res, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Lc1750().minimumLength("bbbbbbbbbbbbbbbbbbb"));
    }


}
