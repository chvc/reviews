package stackqueue;


import java.util.Stack;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-08 12:37:04
 */
public class Lc84LargestRectangleInHistogram {

    static int MAXN = 100001;

    static int[] stack = new int[MAXN];

    static int r;

    public static void main(String[] args) {

    }

    public int largestRectangleArea1(int[] heights) {
        r = 0;
        // min---max
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            // r == 0 栈是空的
            if (r == 0) {
                stack[r++] = i;
            } else {
                while (r > 0 && heights[stack[r - 1]] >= height) {
                    // 计算面积
                    Integer cur = stack[--r];
                    int left = r == 0 ? -1 : stack[r - 1];
                    ans = Math.max(ans, (i - left - 1) * heights[cur]);
                }
                stack[r++] = i;
            }
        }
        // 如果栈不为空
        while (r>0) {
            Integer cur = stack[--r];
            int left = r == 0 ? -1 : stack[r - 1];
            ans = Math.max(ans, (heights.length - left - 1) * heights[cur]);
        }
        return ans;
    }

    // 使用自己实现的栈
    public int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        // min---max
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= height) {
                    // 计算面积
                    Integer cur = stack.pop();
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    ans = Math.max(ans, (i - left - 1) * heights[cur]);
                }
                stack.push(i);
            }
        }
        // 如果栈不为空
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            ans = Math.max(ans, (heights.length - left - 1) * heights[cur]);
        }
        return ans;
    }

}
