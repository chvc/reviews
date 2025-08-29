package od;

import java.util.Scanner;

/**
 * P00017-字符串序列判定/最后一个有效字符 / 有效子字符串
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Od22SubstringJudge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String l = scanner.nextLine();
        System.out.println(judgeSubString(s, l));
    }

    public static int judgeSubString(String s, String l) {
        int left = 0;
        int ans = -1;
        for (int i = 0; i < l.length(); i++) {
            // 已经到最后一个字符了

            if (l.charAt(i) == s.charAt(left)) {
                left++;
            }
            if (left == s.length()) {
                ans = i;
                break;
            }
        }
        return ans;
    }

}
