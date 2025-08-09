package stackqueue;

import java.util.Stack;

class Lc394 {

    Stack<Character> stack = new Stack<>();

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            // 如果是字母
            if (c - 'a' >= 0 && c - 'a' < 26) {
                if (stack.isEmpty()) {
                    sb.append(c);
                } else {
                    stack.push(c);
                }
            } else if (c == ']') {
                // 如果是有括号的话 就要找左括号
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    char encoded = stack.pop();
                    temp.append(encoded);
                }
                // 额外去掉 左括号
                stack.pop();
                temp.reverse();
                // 找数字
                StringBuilder numSb = new StringBuilder();
                while (!stack.isEmpty() && (stack.peek() - '0' >= 0 && stack.peek() - '0' <= 9)) {
                    numSb.append(stack.pop());
                }
                numSb.reverse();
                // 将结果丢进栈里去
                int times = Integer.parseInt(numSb.toString());
                for (int j = 0; j < times; j++) {
                    for (int k = 0; k < temp.length(); k++) {
                        stack.push(temp.charAt(k));
                    }
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return sb + builder.reverse().toString();
    }
}