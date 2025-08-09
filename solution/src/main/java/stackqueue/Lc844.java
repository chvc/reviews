package stackqueue;

import java.util.Stack;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/3
 */
public class Lc844 {

    public boolean backspaceCompare(String s, String t) {
        String fs = f(s);
        String ft = f(t);
        return fs.equals(ft);
    }

    public String f(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '#') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            return "";
        } else {
            StringBuffer sb = new StringBuffer();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }

}
