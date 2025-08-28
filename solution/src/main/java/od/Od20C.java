package od;


import javax.lang.model.element.VariableElement;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用正则实现
 *
 * @author chenghu
 * @since 2025-08-25 23:25:39
 */
public class Od20C {

    static String ps = "(\\d+)\\$(\\d+)";
    static String psharp = "(\\d+)#(\\d+)";

    static Pattern pattern = Pattern.compile(ps);
    static Pattern patterns = Pattern.compile(psharp);

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
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while (str.contains("$")) {
            Matcher matcher = pattern.matcher(str);
            // 7$3
            StringBuffer sb = new StringBuffer();
            if (matcher.find()) {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                int value = cal(x, y);
                matcher.appendReplacement(sb, String.valueOf(value));
            }
            // 7$3
            matcher.appendTail(sb);
            str = sb.toString();
        }
        while (str.contains("#")) {
            Matcher matcher = patterns.matcher(str);
            // 7$3
            StringBuffer sb = new StringBuffer();
            if (matcher.find()) {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                int value = cal2(x, y);
                matcher.appendReplacement(sb, String.valueOf(value));
            }
            // 7$3
            matcher.appendTail(sb);
            str = sb.toString();
        }
        System.out.println(str);
        // 7$1$2
        // 21+1+2 ==> 24$2 72+2+2==> 76
    }

    public static int cal(int x, int y) {
        return 3 * x + y + 2;
    }

    public static int cal2(int x, int y) {
        return 2 * x + 3 * y + 4;
    }
}
