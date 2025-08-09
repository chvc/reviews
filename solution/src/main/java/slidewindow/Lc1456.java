package slidewindow;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/27
 */
public class Lc1456 {

    public int maxVowels(String s, int k) {
        int res = 0;
        int vol = 0;
        for (int l = 0; l < s.length(); l++) {
            if (isVowels(s.charAt(l))) {
                vol++;
            }
            if (l < k - 1) {
                continue;
            }
            res = Math.max(vol, res);
            if (isVowels(s.charAt(l - k + 1))) {
                vol--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Lc1456().maxVowels("leetcode", 3));
    }

    public boolean isVowels(Character c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
