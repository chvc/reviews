package stackqueue;

import java.util.Stack;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/3
 */
public class Lc2390 {

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '*') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
