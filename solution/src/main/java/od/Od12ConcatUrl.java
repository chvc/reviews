package od;


import java.util.Scanner;

/**
 * P00002-拼接url
 *
 * @author chenghu
 * @since 2025-08-28 23:50:03
 */
public class Od12ConcatUrl {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        if (split.length == 0) {
            System.out.println("/");
            return;
        }
        String pre = split[0];
        StringBuilder sb = new StringBuilder();
        if (split.length == 1) {
            if (pre.isEmpty()) {
                System.out.println("/");
                return;
            } else {
                String s1 = pre.replaceAll("/", "");
                sb.append("/").append(s1).append("/");
                System.out.println(sb.toString());
                return;
            }
        }
        String suf = split[1];
        // 如果都没有前缀
        if (!pre.endsWith("/") && !suf.startsWith("/")) {
            sb.append(pre).append("/").append(suf);
        } else if (pre.endsWith("/") && suf.startsWith("/")) {
            sb.append(pre.substring(0, pre.length() - 1)).append("/").append(suf.substring(1));
        } else {
            sb.append(pre).append(suf);
        }
        System.out.println(sb.toString());
    }

}
