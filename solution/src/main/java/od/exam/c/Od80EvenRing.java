package od.exam.c;

import java.util.Scanner;

/**
 * P00316-最长子字符串的长度（二）/ 环中最长子串
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Od80EvenRing {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'o') {
                cnt++;
            }
        }
        if (cnt % 2 == 0) {
            System.out.println(input.length());
        } else {
            System.out.println(input.length() - 1);
        }
    }
}
