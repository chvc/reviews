package stackqueue;

import java.nio.file.StandardWatchEventKinds;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/3
 */
public class Lc946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pushed.length; i++) {
            map.put(pushed[i], i);
        }
        int start = 0;
        boolean[] used = new boolean[pushed.length + 1];
        for (int i = 0; i < popped.length; i++) {
            int pop = popped[i];
            // 如果栈顶直接相等 直接弹出
            if (!stack.isEmpty() && stack.peek() == pop) {
                stack.pop();
                continue;
            }
            for (int j = 0; j < pushed.length; j++) {
                int num = pushed[j];
                Integer index = map.get(num);
                if (used[index]) {
                    continue;
                }
                if (num != pop) {
                    stack.push(num);
                    used[index] = true;
                } else {
                    stack.push(num);
                    used[index] = true;
                    break;
                }
            }
            Integer peek = stack.peek();
            if (peek != pop) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Lc946().validateStackSequences(new int[]{
                4,7,8,3,6,9
        }, new int[]{
                8,7,9,6,4,3
        }));
    }
}
