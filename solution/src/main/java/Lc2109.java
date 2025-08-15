import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-13 13:49:11
 */
public class Lc2109 {
    public String addSpaces(String s, int[] spaces) {
        Arrays.sort(spaces);
        int l = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < spaces.length; i++) {
            sb.append(s.substring(l, spaces[i]) + " ");
            l = spaces[i];
        }
        if (l < s.length()) {
            sb.append(s.substring(l));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Lc2109 lc2109 = new Lc2109();
        System.out.println(lc2109.addSpaces("LeetcodeHelpsMeLearn", new int[]{
                8, 13, 15
        }));
    }
}
