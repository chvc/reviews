package od.exam.b;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  P00026   华为od机试—仿 LISP 运算
 *
 * @author chenghu
 * @since 2025-08-19 23:20:36
 */
public class Od221SimulationLispCalculation {

    static int where = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expr = null;
        while ((expr = reader.readLine()) != null) {
            //
            try {
                int ans = f(expr.toCharArray(), 0);
                System.out.println(ans);
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }

    public static int f(char[] words, int i) throws Exception {
        int ans = 0;
        int num1 = 0;
        int num2 = 0;
        int blank = 0;
        boolean isNeg = false;
        StringBuilder op = new StringBuilder();
        // 字符串终止 或者等于右括号时 结束计算 返回结果
        while (i < words.length && words[i] != ')') {
            if (words[i] != '(') {
                // 字母 数字
                if (Character.isLetter(words[i])) {
                    op.append(words[i]);
                } else if (Character.isDigit(words[i])) {
                    if (blank == 1) {
                        num1 = num1 * 10 + (words[i] - '0');
                    } else {
                        num2 = num2 * 10 + (words[i] - '0');
                    }
                } else if (words[i] == '-') {
                    isNeg = true;
                } else {
                    if (blank == 1) {
                        // 如果有负号的话 那就要加上负号
                        if (isNeg) {
                            num1 = -num1;
                            isNeg = false;
                        }
                    }
                    blank++;
                }
            } else {
                // 左括号
                int res = f(words, i + 1);
                i = where;
                if (blank == 1) {
                    num1 = res;
                } else {
                    num2 = res;
                }
            }
            i++;
        }
        if (isNeg) {
            num2 = -num2;
        }
        where = i;
        if (op.toString().equals("mul")) {
            ans = num1 * num2;
        }
        if (op.toString().equals("div")) {
            ans = num1 / num2;
        }
        if (op.toString().equals("sub")) {
            ans = num1 - num2;
        }
        if (op.toString().equals("add")) {
            ans = num1 + num2;
        }
        if (op.toString().isEmpty()) {
            ans = num2;
        }
        return ans;
    }

}
