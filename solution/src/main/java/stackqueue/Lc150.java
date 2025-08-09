package stackqueue;

import tree.binary.Lc105;

import java.util.Stack;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/3
 */
public class Lc150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            // 如果是符号 那么取出两个数
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                Integer result = 0;
                if (token.equals("+")) {
                    ans = num1 + num2;
                }
                if (token.equals("-")) {
                    ans = num1 - num2;
                }
                if (token.equals("*")) {
                    ans = num1 * num2;
                }
                if (token.equals("/")) {
                    ans = num1 / num2;
                }
                stack.push(ans);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Lc150().evalRPN(new String[]{
                "4","3","2","/","*","1","+"
        }));
    }

}
