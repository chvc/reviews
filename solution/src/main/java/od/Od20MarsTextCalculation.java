package od;


import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * P00345-火星文计算
 *
 * @author chenghu
 * @since 2025-08-25 23:25:39
 */
public class Od20MarsTextCalculation {
    /**
     * 已知火星人使用的运算符为#、$，其与地球人的等价公式如下：
     * x#y = 2*x+3*y+4
     * x$y = 3*x+y+2
     * 1、其中x、y是无符号整数
     * 2、地球人公式按C语言规则计算
     * 3、火星人公式中，$的优先级高于#，相同的运算符，按从左到右的顺序计算
     * 现有一段火星人的字符串报文，请你来翻译并计算结果
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        // 7#6$5#12
        // 7#(6*3+5+2)#12
        List<String> stack = new Stack<>();
        char[] s = str.toCharArray();
        int cur = 0;
        for (int i = 0; i < s.length; i++) {
            if (Character.isDigit(s[i])) {
                cur = cur * 10 + s[i] - '0';
            } else if (s[i] == '#') {
                if (stack.isEmpty()) {
                    // 直接添加
                    stack.add(String.valueOf(cur));
                    stack.add("" + s[i]);
                    cur = 0;
                } else {
                    // 比较优先级
                    String s1 = stack.get(stack.size() - 1);
                    if (s1.equals("#")) {
                        stack.add(String.valueOf(cur));
                        stack.add("" + s[i]);
                        cur = 0;
                    } else {
                        Integer num = Integer.parseInt(stack.get(stack.size() - 2));
                        stack.remove(stack.size() - 1);
                        stack.remove(stack.size() - 1);
                        Integer res = 3 * num + cur + 2;
                        stack.add(String.valueOf(res));
                        cur = 0;
                        stack.add("" + s[i]);
                    }
                }

            } else {
                // 碰到了 $
                stack.add(String.valueOf(cur));
                stack.add("" + s[i]);
                cur = 0;
            }
        }
        stack.add(String.valueOf(cur));
        int pre = 0;

        for (int i = 2; i < stack.size(); i = i + 2) {
            // 2*x+3*y+4
            if (i == 2) {
                pre = 2 * Integer.parseInt(stack.get(0)) + 3 * Integer.parseInt(stack.get(i)) + 4;
            } else {
                pre = 2 * pre + 3 * Integer.parseInt(stack.get(i)) + 4;
            }
        }
        System.out.println(pre);
    }
}
