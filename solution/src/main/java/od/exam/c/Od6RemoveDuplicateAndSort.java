package od.exam.c;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * P00329-数组去重和排序
 *
 * @author chenghu
 * @since 2025-08-24 00:59:46
 */
public class Od6RemoveDuplicateAndSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
            Map<Integer, Integer> map = new HashMap<>();
            Map<Integer, Integer> fistMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                if (!fistMap.containsKey(nums[i])) {
                    fistMap.put(nums[i], i);
                }
            }
            List<Map.Entry<Integer, Integer>> entries = map.entrySet().stream().sorted((o1, o2) -> {
                Integer v1 = o1.getValue();
                Integer v2 = o2.getValue();
                if (v1 != v2) {
                    return v2 - v1;
                }
                return fistMap.get(o1.getKey()) - fistMap.get(o2.getKey());
            }).collect(Collectors.toList());
            String result = entries
                    .stream()
                    .map(a -> String.valueOf(a.getKey()))
                    .collect(Collectors.joining(","));
            System.out.println(result);
        }
    }

}
