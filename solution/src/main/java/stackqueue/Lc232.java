package stackqueue;


import java.util.Stack;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-27 16:06:03
 */
public class Lc232 {
    class MyQueue {

        Stack<Integer> s1;
        Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                return s2.pop();
            } else {
                return s2.pop();
            }
        }

        public int peek() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                return s2.peek();
            } else {
                return s2.peek();
            }
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }

    }


}
