package od.exam.c;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * P00347—猜数字
 *
 * @author chenghu
 * @since 2025-08-26 02:36:43
 */
public class Od120GuessNumber {

//    设定一组四码的数字作为谜底，另一方猜每猜一个数，出数者就要根据这个数字给出提示，提示以XAYB形式呈现，直到猜中位置。
//
//    其中X表示位置正确的数的个数(数字正确且位置正确)，而Y表示数字正确而位置不对的数的个数例如，当谜底为8123，而猜谜者猜1052时，出题者必须提示0A2B。例如，当谜底为5637，而猜谜者猜4931时，出题者必须提示1A0B。当前已知N组猜谜者猜的数字与提示，如果答案确定，请输出答案，不确定则输出NA。
//    输入描述
//    第一行输入一个正整数，0< N < 100.
//    接下来N行，每一行包含一猜测的数字与提示结果
//            输出描述
//    输出最后的答案，答案不确定则输出NA。
//
//    示例1：
//    输入
//
//6
//
//        4815 1A1B
//
//5716 0A1B
//
//7842 0A1B
//
//4901 0A0B
//
//8585 3A0B
//
//8555 2A1B
//            输出
//3585


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = in.nextLine();
        }

        long start = System.currentTimeMillis();
        int answer = -1; // -1 表示还没找到答案
        for (int i = 0; i <= 9999; i++) {
            String candidate = String.format("%04d", i);
            boolean valid = true;
            for (String s : input) {
                if (!check(s, candidate)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                if (answer != -1) { // 已经找到过一个答案 -> 不唯一
                    System.out.println("NA");
                    return;
                }
                answer = i;
            }
        }
        System.out.println(answer == -1 ? "NA" : String.format("%04d", answer));
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
    }

    private static boolean check(String s, String target) {
        String[] part = s.split(" ");
        String num = part[0];
        int len = target.length();
        StringBuilder targetBuilder = new StringBuilder(target);
        while (len < 4) {
            targetBuilder.insert(0, "0");
            len++;
        }
        target = targetBuilder.toString();
        String result = part[1];
        int x = 0;
        int y = 0;
        Map<Character, Integer> map = new HashMap<>();
        List<Character> unMatch = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (target.charAt(i) == num.charAt(i)) {
                x++;
            } else {
                map.put(target.charAt(i), map.getOrDefault(target.charAt(i), 0) + 1);
                unMatch.add(num.charAt(i));
            }
        }
        for (Character c : unMatch) {
            if (map.containsKey(c) && map.getOrDefault(c, 0) != 0) {
                map.put(c, map.getOrDefault(c, 0) - 1);
                y++;
            }
        }
        return (x + "A" + y + "B").equals(result);
    }


}
