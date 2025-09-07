package od;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * P00276—分奖金
 *
 * @author chenghu
 * @since 2025-09-06 22:57:23
 */
public class Od126AssigningAward {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] awards = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            awards[i] = sc.nextInt();
        }
        // 准备一个栈 存入索引
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < awards.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && awards[stack.peek()] < awards[i]) {
                    // 弹出栈顶
                    Integer index = stack.pop();
                    res[index] = (i - index) * (awards[i] - awards[index]);
                }
                stack.push(i);
            }
        }
        // 结算剩余的
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            res[pop] = awards[pop];
        }
        String s = Arrays.stream(res).boxed().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(s);
    }
}
