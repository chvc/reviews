package od;


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-07 21:58:41
 */
public class Od177CountingNewWord {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String content = sc.nextLine();
        String word = sc.nextLine();
        if (word.length() > content.length()) {
            System.out.println(0);
            return;
        }
        // 统计word的词频
        int k = word.length();
        int[] freq = new int[256];
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i)]++;
        }
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String s = new String(chars);
        // 定滑窗口
        int matched = 0;
        int count = 0;
        for (int i = 0; i < content.length(); i++) {
            char in = content.charAt(i);
            if (freq[in] > 0) {
                matched++;
            }
            freq[in]--;
            if (i + 1 < k) {
                continue;
            }
            // 统计
            if (matched == k) {
                count++;
            }
            char out = content.charAt(i + 1 - k);
            freq[out]++;
            if (freq[out] > 0) {
                matched--;
            }
        }
        System.out.println(count);
    }

}
