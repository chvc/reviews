package slidewindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/26
 */
public class Lc76 {

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (Character c : t.toCharArray()) {
            need.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int shortest = s.length() + 1;
        String res = "";
        while (left < s.length()) {
            if (right + 1 <= s.length() && valid < need.size()) {
                char c = s.charAt(right);
                if (need.containsKey(c)) {
                    window.compute(c, (k, v) -> v == null ? 1 : v + 1);
                    // 相等的时候就表示合格的加一
                    if (Objects.equals(window.get(c), need.get(c))) {
                        valid++;
                    }
                }
                right++;
            } else {
                char c = s.charAt(left);
                if (need.containsKey(c)) {
                    window.compute(c, (k, v) -> v == null ? 1 : v - 1);
                    if (window.get(c).compareTo(need.get(c)) < 0) {
                        valid--;
                    }
                }
                left++;
            }
            if (valid == need.size()) {
                if (shortest >= (right - left)) {
                    res = s.substring(left, right);
                    shortest = right - left;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Lc76().minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }

}
