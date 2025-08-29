package od;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * P00394-字符串中找出连续最长的数字串-正则
 *
 * @author chenghu
 * @since 2025-08-10 11:09:44
 */
public class Od2LongestContinuousNumString {

    static String ps = "[+-]?\\d\\.\\d";

    static Pattern p = Pattern.compile(ps);


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        int maxLen = 0;
        String result = "";
        Pattern p = Pattern.compile("[+-]?\\d+\\.?\\d+");
        Matcher m = p.matcher(input);
        while (m.find()) {
            String s = m.group();
            if (s.length() >= maxLen) {
                maxLen = s.length();
                result = s;
            }
        }
        System.out.println(result);
    }


}
