package od;


import java.util.Scanner;

/**
 * P00295—密码输入检测
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Od387PasswordInputCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int upperLetterCnt = 0;
        int lowerLetterCnt = 0;
        int numCnt = 0;
        int otherCnt = 0;
        String pw = dealWithPassword(input);
        for (Character c : pw.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperLetterCnt++;
            } else if (Character.isLowerCase(c)) {
                lowerLetterCnt++;
            } else if (Character.isDigit(c)) {
                numCnt++;
            } else {
                otherCnt++;
            }
        }
        if (pw.length() >= 8 && upperLetterCnt >= 1 && lowerLetterCnt >= 1 && otherCnt >= 1 && numCnt >= 1) {
            System.out.print(pw + ",true");
        } else {
            System.out.print(pw + ",false");
        }
        scanner.close();
    }

    public static String dealWithPassword(String input) {
        if (input.isEmpty()) {
            return "";
        }
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '<') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
