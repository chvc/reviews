package od;


import java.util.Scanner;
import java.util.Stack;

/**
 * #P00235. 华为od机试—表达式括号匹配
 *
 * @author chenghu
 * @since 2025-09-27 15:56:26
 */
public class Od125ExpressParenthesesMatch {

    /**
     * (1+(2+3)*(3+(8+0))+1-2)这是一个简单的数学表达式,今天不是计算它的值,而是比较它的括号匹配是否正确。
     * <p>
     * 前面这个式子可以简化为(()(()))这样的括号我们认为它是匹配正确的,
     * <p>
     * 而((())这样的我们就说他是错误的。注意括号里面的表达式可能是错的,也可能有多个空格，对于这些我们是不用去管的，
     * <p>
     * 我们只关心括号是否使用正确。
     * <p>
     * 输入
     * <p>
     * 给出一行表达式(长度不超过 100)。
     * <p>
     * 输出
     * <p>
     * 如果匹配正确输出括号的对数，否则输出-1。
     * <p>
     * 样例
     * <p>
     * 示例 1  输入输出示例仅供调试，后台判题数据一般不包含示例
     * <p>
     * 输入
     * <p>
     * (1+(2+3)*(3+(8+0))+1-2)
     * <p>
     * 输出
     * <p>
     * 4
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(f(str));
    }

    public static int f(String str) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        char[] s = str.toCharArray();
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (c == '(') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.isEmpty()) {
                    return -1;
                }
                stack.pop();
                ans++;
            }
        }
        // 栈非空
        if (!stack.isEmpty()) {
            return -1;
        }
        return ans;
    }
}
