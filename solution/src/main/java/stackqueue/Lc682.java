package stackqueue;

import java.util.Stack;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/3
 */
public class Lc682 {

    public int calPoints(String[] operations) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i];
            if (operation.equals("C")) {
                stack.pop();
            } else if (operation.equals("D")) {
                stack.push(String.valueOf(Integer.parseInt(stack.peek()) * 2));
            } else if (operation.equals("+")) {
                String num1 = stack.pop();
                String num2 = stack.peek();
                int res = Integer.parseInt(num2) + Integer.parseInt(num1);
                stack.push(num1);
                stack.push(String.valueOf(res));
            } else {
                stack.push(operation);
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += Integer.parseInt(stack.pop());
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc682 lc682 = new Lc682();
        System.out.println(lc682.calPoints(new String[]{
                "5", "2", "C", "D", "+"
        }));
        System.out.println(lc682.calPoints(new String[]{
                "5","-2","4","C","D","9","+","+"
        }));
    }
}
