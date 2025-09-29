package od;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * P00092—选修课
 *
 * @author chenghu
 * @since 2025-09-27 21:46:14
 */
public class Od299ClassScore {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer[]> studentMap = new HashMap<>();

        String s1 = sc.nextLine();
        String[] s1s = s1.split(";");
        for (String s : s1s) {
            String[] split = s.split(",");
            int score = Integer.parseInt(split[1]);
            Integer[] scores = new Integer[3];
            scores[0] = score;
            studentMap.put(split[0], scores);
        }
        String s2 = sc.nextLine();
        String[] s2s = s2.split(";");
        for (String s : s2s) {
            String[] split = s.split(",");
            int score = Integer.parseInt(split[1]);
            Integer[] scores = studentMap.getOrDefault(split[0], new Integer[3]);
            scores[1] = score;
            if (scores[0] != null) {
                scores[2] = scores[0] + scores[1];
            }
            studentMap.put(split[0], scores);
        }
        //
        Set<Map.Entry<String, Integer[]>> entries = studentMap.entrySet();
        List<Map.Entry<String, Integer[]>> collect = entries.stream().filter(e -> {
            Integer[] value = e.getValue();
            return value[2] != null;
        }).collect(Collectors.toList());
        if (collect.isEmpty()) {
            System.out.println("NULL");
            return;
        }
        TreeMap<String, List<Map.Entry<String, Integer[]>>> mapping = collect
                .stream()
                .collect(Collectors.groupingBy(s -> s.getKey().substring(0, 5), TreeMap::new, Collectors.toList()));
        for (Map.Entry<String, List<Map.Entry<String, Integer[]>>> entry : mapping.entrySet()) {
            String key = entry.getKey();
            System.out.println(key);
            List<Map.Entry<String, Integer[]>> entryList = entry.getValue();
            String s = entryList.stream().sorted((e1, e2) -> {
                Integer x1 = e1.getValue()[2];
                Integer x2 = e2.getValue()[2];
                if (!Objects.equals(x1, x2)) {
                    return x2 - x1;
                }
                return e1.getKey().compareTo(e2.getKey());
            }).collect(Collectors.toList()).stream().map(Map.Entry::getKey).collect(Collectors.joining(";"));
            System.out.println(s);
        }
    }


}
