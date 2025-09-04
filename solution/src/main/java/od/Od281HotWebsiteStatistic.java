package od;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * P00131—热点网站统计
 *
 * @author chenghu
 * @since 2025-09-05 05:38:31
 */
public class Od281HotWebsiteStatistic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> freq = new HashMap<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            // 说明是网站
            if (s.contains(".")) {
                freq.put(s, freq.getOrDefault(s, 0) + 1);
            } else {
                // 说明是数字
                int i = Integer.parseInt(s);
                // 将Map的values排序
                List<Map.Entry<String, Integer>> entries = freq.entrySet().stream().sorted((o1, o2) -> {
                    Integer v1 = o1.getValue();
                    Integer v2 = o2.getValue();
                    if (!Objects.equals(v1, v2)) {
                        return v2 - v1;
                    }
                    return o1.getKey().compareTo(o2.getKey());
                }).collect(Collectors.toList());
                // 要输出i个
                List<String> res = new ArrayList<>();
                int min = Math.min(i, entries.size());
                for (int j = 0; j < min; j++) {
                    res.add(entries.get(j).getKey());
                }
                String ans = res.stream().collect(Collectors.joining(","));
                System.out.println(ans);
            }
        }
    }

}
