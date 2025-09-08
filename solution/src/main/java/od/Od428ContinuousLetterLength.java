package od;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * #P00183—连续字母长度
 *
 * @author chenghu
 * @since 2025-09-08 13:20:45
 */
public class Od428ContinuousLetterLength {

    static Map<Character, Integer> freq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = Integer.parseInt(sc.nextLine());
        freq = new HashMap<>();
        fre(str.toCharArray());
        // 拿出第k大的
        List<Map.Entry<Character, Integer>> entries = freq
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .collect(Collectors.toList());
        // 第k大
        if (k <= 0 || k > entries.size()) {
            System.out.println(0);
            return;
        }
        Integer ans = entries.get(k - 1).getValue();
        System.out.println(ans);
    }

    public static void fre(char[] s) {
        int cur = 0;
        char preCur = ' ';
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (preCur == ' ') {
                preCur = c;
                cur++;
            } else {
                if (preCur != c) {
                    // 结算前一个字符
                    Integer cnt = freq.getOrDefault(preCur, 0);
                    if (cur > cnt) {
                        freq.put(preCur, cur);
                    }
                    cur = 1;
                    preCur = c;
                } else {
                    cur++;
                }
            }
        }
        if (cur != 0) {
            Integer cnt = freq.getOrDefault(preCur, 0);
            if (cur > cnt) {
                freq.put(preCur, cur);
            }
        }
    }

}
