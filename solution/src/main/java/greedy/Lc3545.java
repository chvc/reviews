package greedy;


import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-14 21:45:12
 */
public class Lc3545 {

    int[] freq = new int[26];

    public int minDeletion(String s, int k) {
        Arrays.fill(freq, Integer.MAX_VALUE);
        // 要排序
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            freq[charArray[i] - 'a'] = freq[charArray[i] - 'a'] == Integer.MAX_VALUE ? 1 : freq[charArray[i] - 'a']+1;
        }
        Arrays.sort(freq);
        long count = Arrays.stream(freq).filter(f -> f != Integer.MAX_VALUE && f != 0).count();
        if (count == k) {
            return 0;
        }
        int ans = 0;
        int index = 0;
        while (count > k) {
            if (freq[index] == 0 || freq[index] == Integer.MAX_VALUE) {
                index++;
                continue;
            } else {
                ans += freq[index];
                index++;
                count--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc3545 lc3545 = new Lc3545();
        System.out.println(lc3545.minDeletion("yyyzz", 1));
    }

}
