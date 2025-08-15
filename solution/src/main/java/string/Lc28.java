package string;


import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-11 21:28:36
 */
public class Lc28 {

    public int strStr(String haystack, String needle) {
        return kmp(haystack, needle);
    }

    public int kmp(String hayStack, String needle) {

        // 求next数组
        int m = hayStack.length();
        int n = needle.length();
        int[] next = next(needle.toCharArray(), n);
        int x = 0;
        int y = 0;
        while (x < m && y < n) {
            // 如果相等 就都往前走
            if (hayStack.charAt(x) == needle.charAt(y)) {
                x++;
                y++;
            } else if (y > 0) {
                y = next[y];
            } else {
                x++;
            }
        }

        return y == n ? x-y : -1;
    }

    public int[] next(char[] needles, int n) {
        if (n == 0) {
            return new int[]{
                    -1
            };
        }
        int[] next = new int[n];
        next[0] = -1;
        next[1] = 0;
        int findIndex = 0;
        int i = 2;
        while (i < n) {
            if (needles[i - 1] == needles[findIndex]) {
                next[i] = findIndex + 1;
                findIndex++;
                i++;
            } else if (findIndex > 0) {
                findIndex = next[findIndex];
            } else {
                next[i] = 0;
                i++;
            }
        }
        return next;
    }


    public static void main(String[] args) {
        Lc28 lc28 = new Lc28();
        System.out.println(Arrays.toString(lc28.next("aabaaac".toCharArray(), "aabaaac".length())));

    }



}
