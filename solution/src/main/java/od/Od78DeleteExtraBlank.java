package od;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * P00411—去除多余空格
 * // todo 待实现
 * @author chenghu
 * @since 2025-09-07 23:54:45
 */
public class Od78DeleteExtraBlank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String originStr = sc.nextLine();
        String[] indexs = sc.nextLine().split(",");
        // 拿到所有的单词
        if (originStr.isEmpty()) {
            System.out.println();
            System.out.println();
            return;
        }
        String joined = removeBlank(originStr);
        if (indexs.length == 1 && indexs[0].isEmpty()) {
            System.out.println(originStr);
            System.out.println();
            return;
        }
        String[] words = new String[indexs.length];
        for (int i = 0; i < indexs.length; i++) {
            String[] split = indexs[i].split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            String w = originStr.substring(start, end + 1);
            String key = key(w, start);
            words[i] = key;
        }
        // 处理原字符串
        String search = joined;
        // 查找单词
        int[][] res = new int[words.length][2];
        StringBuilder replace = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String key = words[i];
            String[] split = key.split("#");
            String word = split[0];
            if (map.containsKey(key)) {
                Integer start = map.get(key);
                res[i][0] = start;
                res[i][1] = start + word.length() - 1;
            } else {
                int start = search.indexOf(word);
                res[i][0] = start;
                res[i][1] = start + word.length() - 1;
                for (int j = 0; j < word.length(); j++) {
                    replace.append(" ");
                }
                search = search.replace(word, replace.toString());
                replace.setLength(0);
                map.put(key, start);
            }
        }
        System.out.println(joined);
        for (int i = 0; i < res.length; i++) {
            System.out.print("[" + res[i][0] + "," + res[i][1] + "]");
        }
    }

    private static String removeBlank(String originStr) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean quote = false;
        char[] s = originStr.toCharArray();
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (quote) {
                if (c == '\'') {
                    // 结尾 结算
                    sb.append(c);
                    list.add(sb.toString());
                    sb.setLength(0);
                    quote = false;
                } else {
                    sb.append(c);
                }
            } else {
                if (c == '\'') {
                    sb.append(c);
                    quote = true;
                } else if (c == ' ') {
                    if (sb.length() > 0) {
                        list.add(sb.toString());
                        sb.setLength(0);
                    }
                } else {
                    sb.append(c);
                }
            }
        }
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        // 对list用 " "拼接
        String joined = String.join(" ", list);
        return joined;
    }

    public static String key(String word, int start) {
        return word + "#" + start;
    }
}
