package slidewindow;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/30
 */
public class Lc2904 {

    public String shortestBeautifulSubstring(String s, int k) {
        int l = 0;
        int r = -1;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        String res = s;
        while (l < s.length()) {
            if (r < s.length() - 1 && sum < k) {
                r++;
                char c = s.charAt(r);
                int i = c - '0';
                sum = sum + i;
            } else {
                if (sum == k) {
                    // 找到了美丽字符串
                    String curStr = s.substring(l, r + 1);
                    if (len >= curStr.length() && curStr.compareTo(res) >= 0) {
                        // 更换
                        res = curStr;
                        len = curStr.length();
                    }
                }
                char cl = s.charAt(l);
                int il = cl - '0';
                sum = sum - il;
                l++;
            }
        }
        return res.equals(s) ? "" : res;
    }

    public static void main(String[] args) {
        System.out.println(new Lc2904().shortestBeautifulSubstring("110101000010110101", 3));
    }

}
