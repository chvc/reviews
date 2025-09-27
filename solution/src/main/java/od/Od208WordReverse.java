package od;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * #P00119. 华为od机试—单词倒序
 *
 * @author chenghu
 * @since 2025-09-27 17:28:51
 */
public class Od208WordReverse {

    /**
     * 输入单行英文句子，里面包含英文字母，空格以及.? 三种标点符号，请将句子内每个单词进行倒序，并输出倒序后的语句
     * 输入描述:
     * 输入字符串S，S的长度1≤N≤100
     * 输出描述:
     * 输出逆序后的字符串
     * 补充说明:
     * 标点符号左右的空格>=0，单词间空格 >0
     * <p>
     * 示例1
     * 输入:
     * yM eman si boB.
     * 输出:
     * My name is Bob.
     * 示例2
     * 输入:
     * woh era uoy ? I ma enif.
     * 输出:
     * how are you ? I am fine.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<String> f = f(str);
        f.forEach(System.out::print);
    }

    public static List<String> f(String word) {
        ArrayList<String> list = new ArrayList<>();
        char[] s = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (Character.isLetter(c)) {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    list.add(sb.toString());
                    sb.setLength(0);
                }
                list.add(String.valueOf(c));
            }
        }
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        List<String> res = list.stream().map(e -> {
            if (!(e.equals(" ") || e.equals(".") || e.equals("?"))) {
                StringBuilder sb1 = new StringBuilder(e);
                e = sb1.reverse().toString();
                return e;
            } else {
                return e;
            }
        }).collect(Collectors.toList());
        return res;

    }

}
