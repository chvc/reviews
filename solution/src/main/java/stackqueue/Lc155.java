package stackqueue;

import java.util.Stack;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Lc155 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public Lc155() {

    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            Integer peek = minStack.peek();
            if (peek <= val) {
                minStack.push(peek);
            } else {
                minStack.push(val);
            }
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
        if (!minStack.isEmpty()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
