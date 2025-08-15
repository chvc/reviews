package rec;


import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-13 10:59:42
 */
public class Lc224 {

    int where = 0;

    public int calculate(String s) {
        char[] input = s.toCharArray();
        return f(0, input);
    }

    public int f(int i, char[] input) {
        int cur = 0;
        List<Integer> num = new ArrayList<>();
        List<Character> op = new ArrayList<>();
        while (i < input.length && input[i] != ')') {
            if (input[i] == '(') {
                cur = f(i + 1, input);
                i = where;
            } else if (input[i] - '0' >= 0 && input[i] - '0' <= 9) {
                // 数字
                cur = cur * 10 + input[i] - '0';
            } else if (input[i] == '-' || input[i] == '+') {
                // 如果发现顶部是 * / 先计算 再放入
                if (op.isEmpty()) {
                    num.add(cur);
                    op.add(input[i]);
                    cur = 0;
                } else {
                    Character c = op.get(op.size() - 1);
                    if (c == '*' || c == '/') {
                        // 先计算 再放入
                        Integer a = num.get(num.size() - 1);
                        num.remove(num.size() - 1);
                        int res;
                        if (c == '*') {
                            res = a * cur;
                        } else {
                            res = a / cur;
                        }
                        num.add(res);
                        cur = 0;
                        op.remove(op.size() - 1);
                        op.add(input[i]);
                    } else {
                        num.add(cur);
                        op.add(input[i]);
                        cur = 0;
                    }
                }
            } else if (input[i] == '*' || input[i] == '/') {
                // * /
                // 如果发现顶部是 * / 先计算 再放入
                if (op.isEmpty()) {
                    num.add(cur);
                    op.add(input[i]);
                    cur = 0;
                } else {
                    Character c = op.get(op.size() - 1);
                    if (c == '*' || c == '/') {
                        // 先计算 再放入
                        Integer a = num.get(num.size() - 1);
                        num.remove(num.size() - 1);
                        int res;
                        if (c == '*') {
                            res = a * cur;
                        } else {
                            res = a / cur;
                        }
                        num.add(res);
                        cur = 0;
                        op.remove(op.size() - 1);
                        op.add(input[i]);
                    } else {
                        num.add(cur);
                        op.add(input[i]);
                        cur = 0;
                    }
                }
            } else {
                // 如果是空格就啥也不做
            }
            i++;
        }
        if (cur != 0) {
            // 加进去
            num.add(cur);
            cur = 0;
            op.add('+');
        }
        int pre = 0;
        char preOp = ' ';
        // 只有加减了
        for (int j = 0; j < num.size(); j++) {
            if (preOp == ' ') {
                pre = num.get(j);
                preOp = op.get(j);
            } else {
                if (preOp == '+') {
                    pre = pre + num.get(j);
                    preOp = op.get(j);
                } else {
                    pre = pre - num.get(j);
                    preOp = op.get(j);
                }
            }
        }
        where = i;
        return pre;
    }

    public static void main(String[] args) {
        Lc224 lc224 = new Lc224();
        System.out.println(lc224.calculate("1 + 1"));
    }


}
