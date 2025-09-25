package od;


import java.util.Scanner;

/**
 * #P00219—求字符串中所有整数的最小和
 *
 * @author chenghu
 * @since 2025-09-24 21:31:48
 */
public class Od275MinimumSumOfIntegerInString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(f(s));
    }

    public static int f(String str) {
        char[] s = str.toCharArray();
        boolean sign = true;
        int cur = 0;
        int ans = 0;
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (Character.isLetter(c)) {
                // 需要结算
                if (!sign) {
                    cur = cur * -1;
                    ans += cur;
                    sign = true;
                    cur = 0;
                }

            } else if (Character.isDigit(c)) {
                // 如果是正数 立即结算
                if (sign) {
                    ans += c - '0';
                } else {
                    cur = cur * 10 + c - '0';
                }
            } else {
                if (c == '-') {
                    if (!sign) {
                        // 结算
                        cur = cur * -1;
                        ans += cur;
                        sign = false;
                        cur = 0;
                    } else {
                        sign = false;
                    }
                }else {
                    if (!sign) {
                        // 结算
                        cur = cur * -1;
                        ans += cur;
                        sign = true;
                        cur = 0;
                    } else {
                        sign = true;
                    }
                }
            }
        }
        if (cur != 0) {
            // 一定是负数
            ans += cur * -1;
        }
        return ans;
    }

    public static int f2(String str) {
        int ans = 0;
        int n = str.length();
        for (int i = 0; i < n; ) {
            char c = str.charAt(i);

            // 负数模式
            if (c == '-') {
                int j = i + 1;
                int num = 0;
                boolean hasDigit = false;
                while (j < n && Character.isDigit(str.charAt(j))) {
                    num = num * 10 + (str.charAt(j) - '0');
                    j++;
                    hasDigit = true;
                }
                if (hasDigit) {
                    ans -= num; // 整个负数
                }
                i = j;
            }
            // 正数模式（逐位累加）
            else if (Character.isDigit(c)) {
                ans += (c - '0');
                i++;
            }
            else {
                i++;
            }
        }
        return ans;
    }
}
