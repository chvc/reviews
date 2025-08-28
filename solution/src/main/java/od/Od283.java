package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-20 00:59:13
 */
public class Od283 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            // 单词接龙
            int index = Integer.parseInt(line);
            int num = Integer.parseInt(reader.readLine());
            String[] words = new String[num];
            for (int i = 0; i < num; i++) {
                words[i] = reader.readLine();
            }
            //
            String start = words[index];
            // 按照单词长度字典序排序
            Arrays.sort(words, (o1, o2) -> {
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                } else {
                    return o1.compareTo(o2);
                }
            });
            Set<String> set = new HashSet<>();
            set.add(start);
            char c = start.charAt(start.length() - 1);
            StringBuilder sb = new StringBuilder();
            sb.append(start);
            for (int i = 0; i < words.length; i++) {
                if (!set.contains(words[i]) && words[i].startsWith("" + c)) {
                    sb.append(words[i]);
                    set.add(words[i]);
                    c = words[i].charAt(words[i].length() - 1);
                }
            }
            System.out.println(sb.toString());
        }
    }

}
