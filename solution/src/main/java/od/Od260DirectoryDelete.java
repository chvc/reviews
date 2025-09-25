package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * #P00375—树形目录删除
 *
 * @author chenghu
 * @since 2025-09-25 23:21:42
 */
public class Od260DirectoryDelete {

    static Map<Integer, Boolean> deletedDir = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int[] edge = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.computeIfAbsent(edge[1],k->new ArrayList<>());
            List<Integer> list = graph.get(edge[1]);
            list.add(edge[0]);
            deletedDir.put(edge[0], false);
            deletedDir.put(edge[1], false);
        }
        int deleteDir = Integer.parseInt(sc.nextLine());
        delete(graph, deleteDir);
        List<Integer> entries = deletedDir
                .entrySet()
                .stream()
                .filter(e -> e.getKey() != 0 && !e.getValue())
                .map(e -> e.getKey())
                .sorted()
                .collect(Collectors.toList());
        String s = entries.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(s);
    }

    public static void delete(Map<Integer, List<Integer>> graph, int deleteDir) {
        deletedDir.put(deleteDir, true);
        List<Integer> children = graph.get(deleteDir);
        if (children == null || children.isEmpty()) {
            return;
        }
        for (Integer child : children) {
            delete(graph, child);
        }
    }

}
