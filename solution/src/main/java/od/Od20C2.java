package od;


import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-26 01:04:27
 */
public class Od20C2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        Pattern p1 = Pattern.compile("[0-9]+\\$[0-9]+");
        Matcher m1 = p1.matcher(s);
        while (m1.find()) {
            StringBuffer sb = new StringBuffer();
            String temp = m1.group();
            int[] nums = Arrays.stream(temp.split("\\$")).mapToInt(Integer::parseInt).toArray();
            int result = nums[0] * 3 + nums[1] + 2;
            s = s.replaceFirst(Pattern.quote(temp), String.valueOf(result));
            m1 = p1.matcher(s);
        }

        Pattern p2 = Pattern.compile("[0-9]+#[0-9]+");
        Matcher m2 = p2.matcher(s);
        while (m2.find()) {
            String temp = m2.group();
            int[] nums = Arrays.stream(temp.split("#")).mapToInt(Integer::parseInt).toArray();
            int result = nums[0] * 2 + 3 * nums[1] + 4;
            s = s.replace(temp, String.valueOf(result));
            m2 = p2.matcher(s);
        }
        System.out.println(s);
    }

}
