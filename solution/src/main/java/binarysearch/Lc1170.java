package binarysearch;

import java.util.Arrays;
import java.util.Stack;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/2
 */
public class Lc1170 {

    Stack<Character> stack = new Stack<>();

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        // 对 word进行f函数
        int[] wordsf = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordsf[i] = f(words[i]);
        }
        // 将wordsf 排序
        Arrays.sort(wordsf);
        // 在数组中找到的次数
        // 对query进行处理
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int f = f(queries[i]);
            int index = 0;
            for (int j = 0; j < wordsf.length; j++) {
                if (f >= wordsf[j]) {
                    index++;
                } else {
                    break;
                }
            }
            answer[i] = wordsf.length - index;
        }
        return answer;
    }


    public int f(String str) {
        stack.clear();
        // 先清空栈
        if (str.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        // 循环字符串 将字符添加进去
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            // 看一下栈顶的元素
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                while (!stack.isEmpty()) {
                    Character peek = stack.peek();
                    if (peek - c > 0) {
                        // 如果栈顶的元素比c大 就出栈 不能break
                        stack.pop();
                        // 相等的话 就加进去
                    } else if (peek - c == 0) {
                        stack.push(c);
                        break;
                    } else {
                        // 如果 栈顶的元素更小就
                        break;
                    }
                }
                if (stack.isEmpty()) {
                    stack.push(c);
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        int zaaaz = new Lc1170().f("zaaaz");
        System.out.println(zaaaz);
        System.out.println(Arrays.toString(new Lc1170().numSmallerByFrequency(new String[]{
                "cbd"
        }, new String[]{
                "zaaaz"
        })));
    }

}
