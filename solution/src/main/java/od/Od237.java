package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-23 23:56:15
 */
public class Od237 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int count = 0;
        char lastChar = ' ';
        int cur = 0;
        while ((line = reader.readLine()) != null) {
            char[] s = line.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                if (Character.isDigit(s[i])) {
                    cur = cur * 10 + s[i] - '0';
                } else if (s[i] >= 'a' && s[i] <= 'z') {
                    if (cur == 0) {
                        if (lastChar == s[i]) {
                            count++;
                        } else {
                            lastChar = s[i];
                            count = 1;
                        }
                        if (count > 2) {
                            System.out.println("!error");
                            return;
                        } else {
                            sb.append(s[i]);
                        }
                    } else if (cur > 2) {
                        if (count > 2 && lastChar == s[i]) {
                            System.out.println("!error");
                            return;
                        }
                        for (int j = 0; j < cur; j++) {
                            sb.append(s[i]);
                        }
                        count = cur;
                        lastChar = s[i];
                        cur = 0;
                    } else {
                        System.out.println("!error");
                        return;
                    }
                } else {
                    System.out.println("!error");
                    return;
                }
            }
            if (cur != 0) {
                System.out.println("!error");
                return;
            }
            System.out.println(sb.toString());
        }
    }
}
