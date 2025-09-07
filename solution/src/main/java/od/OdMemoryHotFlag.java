package od;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *  #P00082—内存冷热标记
 *
 * @author chenghu
 * @since 2025-09-06 06:35:46
 */
public class OdMemoryHotFlag {

    static Map<Integer, Integer> freq = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int threshold = sc.nextInt();
        // 对Map 进行排序
        List<Map.Entry<Integer, Integer>> entries = freq.entrySet().stream().filter(e -> e.getValue() - threshold >= 0).sorted((o1, o2) -> {
            Integer k1 = o1.getKey();
            Integer k2 = o2.getKey();
            Integer v1 = o1.getValue();
            Integer v2 = o2.getValue();
            if (!Objects.equals(v1, v2)) {
                return v2 - v1;
            }
            return k1 - k2;
        }).collect(Collectors.toList());
        if (entries.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(entries.size());
            entries.forEach(e-> System.out.println(e.getKey()));
        }
    }

}
