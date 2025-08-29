package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * P00343—查找众数及中位数
 *
 * @author chenghu
 * @since 2025-08-25 22:09:50
 */
public class Od204FindModeAndMedian {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            freq.put(nums.get(i), freq.getOrDefault(nums.get(i), 0) + 1);
        }
        // 对map进行排序
        List<Map.Entry<Integer, Integer>> entries = freq.entrySet().stream().sorted((o1, o2) -> {
            Integer v1 = o1.getValue();
            Integer v2 = o2.getValue();
            if (!Objects.equals(v1, v2)) {
                return v2 - v1;
            }
            Integer k1 = o1.getKey();
            Integer k2 = o2.getKey();
            return k1  - k2;
        }).collect(Collectors.toList());
        Integer maxSize = entries.get(0).getValue();
        List<Integer> nl = new ArrayList<>();
        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<Integer, Integer> entry = entries.get(i);
            if (Objects.equals(entry.getValue(), maxSize)) {
                nl.add(entry.getKey());
            }
        }
        // 寻找中位数
        if (nl.size() % 2 != 0) {
            System.out.println(nl.get(nl.size() / 2));
        } else {
            int i = nl.size() / 2;
            Integer i1 = nl.get(i - 1);
            Integer i2 = nl.get(i);
            System.out.println((i2 - i1) / 2 + i1);
        }
    }
}
