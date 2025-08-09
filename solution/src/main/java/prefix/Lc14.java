package prefix;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/9
 */
public class Lc14 {

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        String longestCommonPrefix = strs[0];
        int start = 0;
        for (int i = 0; i < longestCommonPrefix.length(); i++) {
            char c = longestCommonPrefix.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                // 其他字符串
                char c1 = str.charAt(i);
                if (c != c1) {
                    return longestCommonPrefix.substring(0, i);
                }
            }
        }
        return longestCommonPrefix;
    }

    public static void main(String[] args) {
        Lc14 lc14 = new Lc14();
        System.out.println(lc14.longestCommonPrefix(new String[]{
                "ab", "a"
        }));
        System.out.println(lc14.longestCommonPrefix(new String[]{
                "flower","flow","flight"
        }));
        System.out.println(lc14.longestCommonPrefix(new String[]{
                "reflower", "flow", "flight"
        }));
    }

}
