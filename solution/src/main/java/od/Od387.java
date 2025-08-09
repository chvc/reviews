package od;


import java.util.Scanner;
import java.util.Stack;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Od387 {

    static Stack<Character> STACK = new Stack<>();

    static int UPPER_LETTER_CNT = 0;

    static int LOWER_LETTER_CNT = 0;

    static int NUM_CNT = 0;

    static int OTHER_CNT = 0;

    static StringBuffer SB = new StringBuffer();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String pw = dealWithPassword(input);
        System.out.print(pw);
        System.out.print(",");
        for (Character c : pw.toCharArray()) {
            if (c - 'A' >= 0 && c - 'A' < 26) {
                UPPER_LETTER_CNT++;
            } else if (c - 'a' >= 0 && c - 'a' < 26) {
                LOWER_LETTER_CNT++;
            } else if (c - '0' >= 0 && c - '0' < 9) {
                NUM_CNT++;
            } else {
                // 其他字符
                if (c != ' ') {
                    OTHER_CNT++;
                }
            }
        }
        if (pw.length() >= 8 && UPPER_LETTER_CNT >= 1 && LOWER_LETTER_CNT >= 1 && OTHER_CNT >= 1 && NUM_CNT >= 1) {
            System.out.print(true);
        } else {
            System.out.print(false);
        }
        scanner.close();

//        System.out.println('9' - '0');
    }

    public static String dealWithPassword(String input) {
        if (input.isEmpty()) {
            return "";
        }
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '<') {
                if (!STACK.isEmpty()) {
                    STACK.pop();
                }
            } else {
                // 其他字符
                if (c != ' ') {
                    STACK.push(c);
                }
            }
        }

        while (!STACK.isEmpty()) {
            SB.append(STACK.pop());
        }
        String pw = SB.reverse().toString();
        return pw;
    }

}
