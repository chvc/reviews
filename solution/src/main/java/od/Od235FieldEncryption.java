package od;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * P00184—敏感字段加密
 * // todo 用正则比较快速
 *
 * @author chenghu
 * @since 2025-09-07 23:14:19
 */
public class Od235FieldEncryption {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        boolean quote = false;
        char[] s = str.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            // 如果出现了引号
            if (quote) {
                // 得判断是不是引号
                if (c == '"') {
                    sb.append(c);
                    // 结算
                    list.add(sb.toString());
                    sb.setLength(0);
                    quote = false;
                } else {
                    sb.append(c);
                }
            } else {
                if (c == '_') {
                    // 结算
                    if (sb.length() > 0) {
                        list.add(sb.toString());
                        sb.setLength(0);
                    }
                } else if (c == '"') {
                    sb.append(c);
                    quote = true;
                } else {
                    sb.append(c);
                }
            }
        }
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        if (list.size() <= index) {
            System.out.println("ERROR");
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (i == index) {
                    String s1 = list.get(i);
                    s1 = "******";
                    list.set(i, s1);
                }
            }
            String out = String.join("_", list);
            System.out.println(out);
        }
    }
}
