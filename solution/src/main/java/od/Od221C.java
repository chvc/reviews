package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-20 00:03:29
 */
public class Od221C {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expr = null;
        // (sub (mul 2 4) (div 9 3))
        while ((expr = reader.readLine()) != null) {
            Stack<String> opStack = new Stack<>();
            char[] charArray = expr.toCharArray();
            StringBuilder num = new StringBuilder();
            StringBuilder op = new StringBuilder();
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == '(') {
                    opStack.push("(");
                } else if (charArray[i] == ' ') {
                    if (op.length() > 0) {
                        opStack.push(op.toString());
                        op.setLength(0);
                    }
                    if (num.length() > 0) {
                        opStack.push(num.toString());
                        num.setLength(0);
                    }
                } else if (charArray[i] == ')') {
                    if (num.length() > 0) {
                        opStack.push(num.toString());
                        num.setLength(0);
                    }
                    // 计算
                    String cal = cal(opStack);
                    opStack.push(cal);
                } else {
                    if (Character.isLetter(charArray[i])) {
                        op.append(charArray[i]);
                    }
                    if (Character.isDigit(charArray[i])) {
                        num.append(charArray[i]);
                    }
                }
            }
            String answer = opStack.pop();
            System.out.println(answer);
        }

    }

    public static String cal(Stack<String> stack) {
        String num2 = stack.pop();
        String num1 = stack.pop();
        String op = stack.pop();
        String pop = stack.pop();
        int i1 = Integer.parseInt(num1);
        int i2 = Integer.parseInt(num2);
        int ans = 0;
        if (op.equals("mul")) {
            ans = i1 * i2;
        }
        if (op.equals("div")) {
            ans = i1 / i2;
        }
        if (op.equals("add")) {
            ans = i1 + i2;
        }
        if (op.equals("sub")) {
            ans = i1 - i2;
        }
        return String.valueOf(ans);
    }
}
