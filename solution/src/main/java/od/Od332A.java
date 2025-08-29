package od;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-26 02:51:28
 */
public class Od332A {

    // todo 需要实现
    static String p1s = "\\[_\\]";
    static Pattern p1 = Pattern.compile(p1s);
    static String p2s = "\\_";
    static Pattern p2 = Pattern.compile(p2s);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            Matcher m1 = p1.matcher(s);
            while (m1.find()) {
                System.out.println("===>");
            }
        }
    }
}
