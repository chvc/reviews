import java.util.Stack;

class MinStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        s1.push(val);
        if (s2.isEmpty()) {
            s2.push(val);
        } else {
            int peek = s2.peek();
            if (val <= peek) {
                s2.push(val);
            }
        }
    }

    public void pop() {
        int i1 = s1.pop();
        int i2 = s2.peek();
        if (i1 == i2) {
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

}