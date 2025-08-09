package string;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/27
 */
public class Lc8 {

    public int myAtoi(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isDiOrSign(c)) {
                if (sb.toString().isEmpty()) {
                    continue;
                } else {
                    break;
                }
            }
            if (c == '0') {
                if (!sb.toString().isEmpty()) {
                    sb.append(c);
                }
            } else if (c == '-') {
                if (sb.toString().isEmpty()) {
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public boolean isDiOrSign(char c) {
        return c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8'
                || c == '9' || c == '-';
    }

    public static void main(String[] args) {
        System.out.println(new Lc8().myAtoi("0-1"));
    }
}
