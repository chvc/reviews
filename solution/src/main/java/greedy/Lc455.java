package greedy;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-14 22:49:38
 */
public class Lc455 {

    public int findContentChildren(int[] g, int[] s) {
        g = Arrays.stream(g).boxed().sorted(Comparator.reverseOrder()).mapToInt(a -> a).toArray();
        s = Arrays.stream(s).boxed().sorted(Comparator.reverseOrder()).mapToInt(a -> a).toArray();
        int count = 0;
        int j = 0;
        int i = 0;
        while (i < g.length && j < s.length) {
            if (g[i] > s[j]) {
                i++;
            } else {
                i++;
                j++;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Lc455 lc455 = new Lc455();
        System.out.println(lc455.findContentChildren(new int[]{
                1, 2, 3
        }, new int[]{
                1, 1
        }));
    }
}
