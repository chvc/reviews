package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 找到比自己强的人 / 师徒关系
 *
 * @author chenghu
 * @since 2025-08-29 15:59:40
 */
public class Od398ABetterTeacher {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        String s = input.trim().replaceAll("[^0-9]", " ").trim();
        if (s.isEmpty()) {
            System.out.println("[]");
            return;

        }
        int[] nums = Arrays
                .stream(
                        s
                                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Set<Integer> persons = new HashSet<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < nums.length; i = i + 2) {
            int x = nums[i];
            int y = nums[i + 1];
            persons.add(x);
            persons.add(y);
            graph.computeIfAbsent(x, k -> new HashSet<>()).add(y);
            graph.computeIfAbsent(y, k -> new HashSet<>());
        }
        // 建图 找出每个人的徒弟
        Map<Integer, Integer> res = new HashMap<>();
        for (Integer person : persons) {
            Set<Integer> t = new HashSet<>();
            find(graph, person, t);
            int cnt = 0;
            for (Integer xx : t) {
                if (xx < person) {
                    cnt++;
                }
            }
            res.put(person, cnt);
        }
        List<Integer> sorted = new ArrayList<>(persons);
        Collections.sort(sorted);
        List<Integer> reslist = new ArrayList<>();
        for (Integer integer : sorted) {
            reslist.add(res.get(integer));
        }
        // 遍历map 看一下哪些大于
        System.out.println("[" + reslist.stream().map(String::valueOf).collect(Collectors.joining(",")) + "]");
    }

    public static void find(Map<Integer, Set<Integer>> map, int x, Set<Integer> allStudents) {
        if (!map.containsKey(x)) {
            return;
        }
        Set<Integer> all = map.get(x);
        for (int a : all) {
            if (allStudents.add(a)) {
                find(map, a, allStudents);
            }
        }
    }

}



