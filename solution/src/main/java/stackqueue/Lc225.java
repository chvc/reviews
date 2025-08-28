package stackqueue;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-27 16:13:35
 */
public class Lc225 {

    class MyStack {

        Queue<Integer> q;

        public MyStack() {
            q = new LinkedList<Integer>();
        }

        public void push(int x) {
            int size = q.size();
            q.add(x);
            for (int i = 0; i < size; i++) {
                q.add(q.poll());
            }
        }

        public int pop() {
            if (q.isEmpty()) {
                return -1;
            }
            return q.poll();
        }

        public int top() {
            if (q.isEmpty()) {
                return -1;
            }
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

}
