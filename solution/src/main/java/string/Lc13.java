package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/2
 */
public class Lc13 {

    Map<Character, Integer> mapping = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        char[] charArray = s.toCharArray();
        int ans = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            char c = charArray[i];
            Integer num = mapping.get(c);
            if (i == 0) {
                ans = ans + num;
                return ans;
            } else {
                if (c == 'I') {
                    ans = ans + num;
                } else if (c == 'V') {

                    if (charArray[i - 1] == 'I') {
                        ans = ans + 4;
                        i--;
                    } else {
                        ans = ans + num;
                    }

                } else if (c == 'X') {

                    if (charArray[i - 1] == 'I') {
                        ans = ans + 9;
                        i--;
                    } else {
                        ans = ans + num;
                    }

                } else if (c == 'L') {

                    if (charArray[i - 1] == 'X') {
                        ans = ans + 40;
                        i--;
                    } else {
                        ans = ans + num;
                    }


                } else if (c == 'C') {

                    if (charArray[i - 1] == 'X') {
                        ans = ans + 90;
                        i--;
                    } else {
                        ans = ans + 100;
                    }

                } else if (c == 'D') {

                    if (charArray[i - 1] == 'C') {
                        ans = ans + 400;
                        i--;
                    } else {
                        ans = ans + 500;
                    }

                } else {

                    if (charArray[i - 1] == 'C') {
                        ans = ans + 900;
                        i--;
                    } else {
                        ans = ans + 1000;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new string.Lc13().romanToInt("III"));
//        System.out.println(new string.Lc13().romanToInt("IV"));
//        System.out.println(new string.Lc13().romanToInt("IX"));
//        System.out.println(new string.Lc13().romanToInt("LVIII"));
        System.out.println(new Lc13().romanToInt("MCMXCIV"));
    }

}
