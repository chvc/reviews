package stackqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/3
 */
public class Lc1006 {

    // 18 -7 11 14 12
    String[] operationArray = new String[]{"*", "/", "+", "-"};

    public int clumsy(int n) {

        List<String> list = create(n);
        return evaluate(list);
    }

    public int evaluate(List<String> tokens) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> operationStack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);

            if (isOperation(token)) {
                operationStack.push(token);
            } else {
                int num = Integer.parseInt(token);
                if (numberStack.isEmpty()) {
                    numberStack.push(num);
                } else {
                    // 是数字
                    if (!operationStack.isEmpty()) {
                        if (Objects.equals(operationStack.peek(), "*") || Objects.equals(operationStack.peek(), "/")) {
                            // 如果是乘除的话
                            Integer number = numberStack.pop();
                            String operation = operationStack.pop();
                            if (operation.equals("*")) {
                                ans = number * num;
                                numberStack.push(ans);
                            } else {
                                ans = number / num;
                                numberStack.push(ans);
                            }
                        } else {
                            // 加减了  加减的话 就直接push就行
                            numberStack.push(num);
                        }
                    }
                }
            }
        }
        int sign = 1;
        List<String> list = new ArrayList<>();
        while (!numberStack.isEmpty()) {
            Integer num = numberStack.pop();
            list.add(String.valueOf(num));
            if (!operationStack.isEmpty()) {
                String pop = operationStack.pop();
                list.add(pop);
            }
        }
        Collections.reverse(list);
        int res = 0;
        String preOp = "";
        for (int i = 0; i < list.size(); i++) {
            String op = list.get(i);
            if (op.equals("+") || op.equals("-")) {
                preOp = op;
            } else {
                if (!preOp.isEmpty()) {
                    if (preOp.equals("+")) {
                        res = res + Integer.parseInt(op);
                    } else {
                        res = res - Integer.parseInt(op);
                    }
                } else {
                    res = Integer.parseInt(op);
                }
            }
        }
        return res;
    }

    public boolean isOperation(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public static void main(String[] args) {
//        System.out.println(new Lc1006().clumsy(10));
        Lc1006 lc1006 = new Lc1006();
        System.out.println(lc1006.evaluate(lc1006.create(1)));
        System.out.println(lc1006.evaluate(lc1006.create(8)));
        System.out.println(lc1006.evaluate(lc1006.create(10)));
    }

    public List<String> create(int n) {

        int index = 0;
        List<String> list = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            String operation = operationArray[index % 4];
            list.add(String.valueOf(i));
            if (i != 1) {
                list.add(operation);
            }
            index++;
        }
        return list;
    }

}
